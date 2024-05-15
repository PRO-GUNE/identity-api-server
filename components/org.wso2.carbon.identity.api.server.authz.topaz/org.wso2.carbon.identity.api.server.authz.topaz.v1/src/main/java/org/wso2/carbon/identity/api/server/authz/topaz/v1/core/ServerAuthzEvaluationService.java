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
 * Class to handle the implementation of the authorization evaluation endpoints.
 */
public class ServerAuthzEvaluationService {

    public AccessCheckResponse authorizerCheck(String tenantId, AccessCheckRequest accessCheckRequest) {

        String tSubjectId = tenantId + JOIN_SYMBOL + accessCheckRequest.getSubject().getId();
        String tResourceId = tenantId + JOIN_SYMBOL + accessCheckRequest.getResource().getId();
        TopazAuthzHandler topazAuthzHandler = TopazAuthzServiceHolder.getTopazAuthzHandler();

        boolean decision = topazAuthzHandler.getTopazDirectoryHandler().check(
                topazAuthzHandler.getObjManagementHandler().createDirectoryRequestObject(
                        accessCheckRequest.getSubject().getType(),
                        tSubjectId,
                        accessCheckRequest.getSubject().getRelation(),
                        accessCheckRequest.getResource().getType(),
                        tResourceId,
                        accessCheckRequest.getRelation().getMethod()));

        AccessCheckResponse accessCheckResponse = new AccessCheckResponse();
        accessCheckResponse.setDecision(decision);

        return accessCheckResponse;
    }

    public PolicyEvaluationResponse policyCheck(String tenantId, PolicyEvaluationRequest policyEvaluationRequest) {

        String tIdentityId = tenantId + JOIN_SYMBOL + policyEvaluationRequest.getIdentityContext().getIdentity();
        TopazAuthzHandler topazAuthzHandler = TopazAuthzServiceHolder.getTopazAuthzHandler();

        CheckAuthzResponse checkAuthzResponse = topazAuthzHandler.getTopazAuthorizerHandler().check(
                topazAuthzHandler.getObjManagementHandler().createIsContextObject(
                        policyEvaluationRequest.getIdentityContext().getType(),
                        tIdentityId,
                        policyEvaluationRequest.getResourceContext(),
                        policyEvaluationRequest.getPolicyContext().getDecisions(),
                        policyEvaluationRequest.getPolicyContext().getPath()));


        PolicyEvaluationResponse policyEvaluationResponse = new PolicyEvaluationResponse();
        policyEvaluationResponse.setDecisions(checkAuthzResponse.getDecisions());

        return policyEvaluationResponse;
    }

    public GraphGenerationResponse graph(String tenantId, GraphGenerationRequest graphGenerationRequest) {

        String tSubjectId = "";
        String tResourceId = "";
        if (!Objects.equals(graphGenerationRequest.getSubject().getId(), "")) {
            tSubjectId = tenantId + JOIN_SYMBOL + graphGenerationRequest.getSubject().getId();
        } else if (!Objects.equals(graphGenerationRequest.getResource().getId(), "")) {
            tResourceId = tenantId + JOIN_SYMBOL + graphGenerationRequest.getSubject().getId();
        }
        TopazAuthzHandler topazAuthzHandler = TopazAuthzServiceHolder.getTopazAuthzHandler();

        DirectoryGraphAuthzResponse directoryGraphAuthzResponse = topazAuthzHandler.getTopazDirectoryHandler().graph(
                topazAuthzHandler.getObjManagementHandler().createDirectoryRequestObject(
                        graphGenerationRequest.getSubject().getType(),
                        tSubjectId,
                        graphGenerationRequest.getSubject().getRelation(),
                        graphGenerationRequest.getResource().getType(),
                        tResourceId,
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

    public DecisionTreeEvaluationResponse decisionTree(String tenantId,
                                                       DecisionTreeEvaluationRequest decisionTreeEvaluationRequest) {

        String tIdentityId = tenantId + JOIN_SYMBOL + decisionTreeEvaluationRequest.getIdentityContext().getIdentity();
        TopazAuthzHandler topazAuthzHandler = TopazAuthzServiceHolder.getTopazAuthzHandler();

        DecisionTreeAuthzResponse decisionTreeAuthzResponse = topazAuthzHandler.getTopazAuthorizerHandler().
                decisiontree(topazAuthzHandler.getObjManagementHandler().createDecisionTreeContextObject(
                        decisionTreeEvaluationRequest.getIdentityContext().getType(),
                        tIdentityId,
                        decisionTreeEvaluationRequest.getResourceContext(),
                        decisionTreeEvaluationRequest.getPolicyContext().getDecisions(),
                        decisionTreeEvaluationRequest.getPolicyContext().getPath(),
                        "."));


        DecisionTreeEvaluationResponse decisionTreeEvaluationResponse = new DecisionTreeEvaluationResponse();
        decisionTreeEvaluationResponse.setDecisions(decisionTreeAuthzResponse.getResponse());

        return decisionTreeEvaluationResponse;
    }
}
