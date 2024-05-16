/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.api.server.authz.topaz.v1.core;

import org.wso2.carbon.context.PrivilegedCarbonContext;
import org.wso2.carbon.identity.api.server.authz.topaz.common.TopazAuthzServiceHolder;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.AccessCheckRequest;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.AccessCheckResponse;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.DecisionTreeEvaluationRequest;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.DecisionTreeEvaluationResponse;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.GraphGenerationRequest;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.GraphGenerationResponse;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.GraphGenerationResponseResults;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.PolicyEvaluationRequest;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.PolicyEvaluationResponse;
import org.wso2.carbon.identity.application.authz.topaz.handler.core.CheckAuthzResponse;
import org.wso2.carbon.identity.application.authz.topaz.handler.core.DecisionTreeAuthzResponse;
import org.wso2.carbon.identity.application.authz.topaz.handler.core.DirectoryEntity;
import org.wso2.carbon.identity.application.authz.topaz.handler.core.DirectoryGraphAuthzResponse;
import org.wso2.carbon.identity.application.authz.topaz.handler.topaz.TopazAuthzHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.wso2.carbon.identity.api.server.authz.topaz.common.Constants.JOIN_SYMBOL;

/**
 * Class to handle the authorization evaluation endpoints.
 */
public class ServerAuthzEvaluationService {
    public AccessCheckResponse authorizerCheck(AccessCheckRequest accessCheckRequest) {

        String orgId = PrivilegedCarbonContext.getThreadLocalCarbonContext().getOrganizationId();

        String oSubjectId = orgId + JOIN_SYMBOL + accessCheckRequest.getSubject().getId();
        String oResourceId = orgId + JOIN_SYMBOL + accessCheckRequest.getResource().getId();
        TopazAuthzHandler topazAuthzHandler = TopazAuthzServiceHolder.getTopazAuthzHandler();

        boolean decision = topazAuthzHandler.getTopazDirectoryHandler().check(
                topazAuthzHandler.getObjManagementHandler().createDirectoryRequestObject(
                        accessCheckRequest.getSubject().getType(),
                        oSubjectId,
                        accessCheckRequest.getSubject().getRelation(),
                        accessCheckRequest.getResource().getType(),
                        oResourceId,
                        accessCheckRequest.getRelation().getMethod()));

        AccessCheckResponse accessCheckResponse = new AccessCheckResponse();
        accessCheckResponse.setDecision(decision);

        return accessCheckResponse;
    }

    public PolicyEvaluationResponse policyCheck(PolicyEvaluationRequest policyEvaluationRequest) {

        String orgId = PrivilegedCarbonContext.getThreadLocalCarbonContext().getOrganizationId();

        String oIdentityId = orgId + JOIN_SYMBOL + policyEvaluationRequest.getIdentityContext().getIdentity();
        TopazAuthzHandler topazAuthzHandler = TopazAuthzServiceHolder.getTopazAuthzHandler();

        CheckAuthzResponse checkAuthzResponse = topazAuthzHandler.getTopazAuthorizerHandler().check(
                topazAuthzHandler.getObjManagementHandler().createIsContextObject(
                        policyEvaluationRequest.getIdentityContext().getType(),
                        oIdentityId,
                        policyEvaluationRequest.getResourceContext(),
                        policyEvaluationRequest.getPolicyContext().getDecisions(),
                        policyEvaluationRequest.getPolicyContext().getPath()));


        PolicyEvaluationResponse policyEvaluationResponse = new PolicyEvaluationResponse();
        policyEvaluationResponse.setDecisions(checkAuthzResponse.getDecisions());

        return policyEvaluationResponse;
    }

    public GraphGenerationResponse graph(GraphGenerationRequest graphGenerationRequest) {

        String oSubjectId = "";
        String oResourceId = "";
        String orgId = PrivilegedCarbonContext.getThreadLocalCarbonContext().getOrganizationId();
        if (!Objects.equals(graphGenerationRequest.getSubject().getId(), "")) {
            oSubjectId = orgId + JOIN_SYMBOL + graphGenerationRequest.getSubject().getId();
        } else if (!Objects.equals(graphGenerationRequest.getResource().getId(), "")) {
            oResourceId = orgId + JOIN_SYMBOL + graphGenerationRequest.getSubject().getId();
        }
        TopazAuthzHandler topazAuthzHandler = TopazAuthzServiceHolder.getTopazAuthzHandler();

        DirectoryGraphAuthzResponse directoryGraphAuthzResponse = topazAuthzHandler.getTopazDirectoryHandler().graph(
                topazAuthzHandler.getObjManagementHandler().createDirectoryRequestObject(
                        graphGenerationRequest.getSubject().getType(),
                        oSubjectId,
                        graphGenerationRequest.getSubject().getRelation(),
                        graphGenerationRequest.getResource().getType(),
                        oResourceId,
                        graphGenerationRequest.getRelation().getMethod()));

        GraphGenerationResponse graphGenerationResponse = new GraphGenerationResponse();
        List<DirectoryEntity> results = directoryGraphAuthzResponse.getResults();
        List<GraphGenerationResponseResults> graphGenerationResponseResultsList = new ArrayList<>();
        for (DirectoryEntity result : results) {
            GraphGenerationResponseResults graphGenerationResponseResults = new GraphGenerationResponseResults();
            graphGenerationResponseResults.setObjectId(result.getObjectId());
            graphGenerationResponseResults.setObjectType(result.getObjectType());

            graphGenerationResponseResultsList.add(graphGenerationResponseResults);
        }

        graphGenerationResponse.setResults(graphGenerationResponseResultsList);
        return graphGenerationResponse;
    }

    public DecisionTreeEvaluationResponse decisionTree(DecisionTreeEvaluationRequest decisionTreeEvaluationRequest) {

        String orgId = PrivilegedCarbonContext.getThreadLocalCarbonContext().getOrganizationId();
        String oIdentityId = orgId + JOIN_SYMBOL + decisionTreeEvaluationRequest.getIdentityContext().getIdentity();
        TopazAuthzHandler topazAuthzHandler = TopazAuthzServiceHolder.getTopazAuthzHandler();

        DecisionTreeAuthzResponse decisionTreeAuthzResponse = topazAuthzHandler.getTopazAuthorizerHandler().
                decisiontree(topazAuthzHandler.getObjManagementHandler().createDecisionTreeContextObject(
                        decisionTreeEvaluationRequest.getIdentityContext().getType(),
                        oIdentityId,
                        decisionTreeEvaluationRequest.getResourceContext(),
                        decisionTreeEvaluationRequest.getPolicyContext().getDecisions(),
                        decisionTreeEvaluationRequest.getPolicyContext().getPath(),
                        "."));


        DecisionTreeEvaluationResponse decisionTreeEvaluationResponse = new DecisionTreeEvaluationResponse();
        decisionTreeEvaluationResponse.setDecisions(decisionTreeAuthzResponse.getResponse());

        return decisionTreeEvaluationResponse;
    }
}
