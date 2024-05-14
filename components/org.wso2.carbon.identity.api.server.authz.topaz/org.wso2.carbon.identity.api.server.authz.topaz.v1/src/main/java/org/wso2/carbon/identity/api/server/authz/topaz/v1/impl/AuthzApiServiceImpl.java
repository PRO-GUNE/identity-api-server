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

package org.wso2.carbon.identity.api.server.authz.topaz.v1.impl;

import org.wso2.carbon.identity.api.server.authz.topaz.v1.*;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.core.ServerAuthzEvaluationService;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.core.ServerAuthzManagementService;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.*;
import java.util.List;

import javax.ws.rs.core.Response;

public class AuthzApiServiceImpl implements AuthzApiService {

    private final ServerAuthzManagementService serverAuthzManagementService = new ServerAuthzManagementService();
    private final ServerAuthzEvaluationService serverAuthzEvaluationService = new ServerAuthzEvaluationService();

    @Override
    public Response authzApiEvalV1TTenantIdDecisiontreePost(String tenantId, DecisionTreeEvaluationRequest decisionTreeEvaluationRequest) {

        DecisionTreeEvaluationResponse decisionTreeEvaluationResponse = serverAuthzEvaluationService.decisionTree(
                tenantId, decisionTreeEvaluationRequest);
        return Response.ok().entity(decisionTreeEvaluationResponse).build();
    }

    @Override
    public Response authzApiEvalV1TTenantIdGraphPost(String tenantId, GraphGenerationRequest graphGenerationRequest) {

        GraphGenerationResponse graphGenerationResponse = serverAuthzEvaluationService.graph(
                tenantId, graphGenerationRequest);
        return Response.ok().entity(graphGenerationResponse).build();
    }

    @Override
    public Response authzApiEvalV1TTenantIdCheckPost(String tenantId, AccessCheckRequest accessCheckRequest) {

        AccessCheckResponse accessCheckResponse = serverAuthzEvaluationService.authorizerCheck(
                tenantId, accessCheckRequest);
        return Response.ok().entity(accessCheckResponse).build();
    }

    @Override
    public Response authzApiEvalV1TTenantIdPolicyPost(String tenantId, PolicyEvaluationRequest policyEvaluationRequest) {

        PolicyEvaluationResponse policyEvaluationResponse = serverAuthzEvaluationService.policyCheck(
                tenantId, policyEvaluationRequest);
        return Response.ok().entity(policyEvaluationResponse).build();
    }

    @Override
    public Response authzApiManageV1TTenantIdRelationDelete(String tenantId, String entityType, String entityId, String relation, String subjectType, String subjectId, String subjectRelation) {

        serverAuthzManagementService.deleteRelation(tenantId, entityType, entityId, relation, subjectType,
                subjectId, subjectRelation);
        return Response.noContent().build();
    }

    @Override
    public Response authzApiManageV1TTenantIdRelationGet(String tenantId, String entityType, String entityId, String relation, String subjectType, String subjectId, String subjectRelation) {

        RelationResponse relationResponse = serverAuthzManagementService.getRelation(tenantId, entityType, entityId,
                relation, subjectType, subjectId, subjectRelation);
        return Response.ok().entity(relationResponse).build();
    }

    @Override
    public Response authzApiManageV1TTenantIdRelationPost(String tenantId, CreationRelationRequestModel creationRelationRequestModel) {

        RelationResponse relationResponse = serverAuthzManagementService.createRelation(tenantId,
                creationRelationRequestModel);
        return Response.ok().entity(relationResponse).build();
    }

    @Override
    public Response authzApiManageV1TTenantIdEntityEntityTypeEntityIdDelete(String tenantId, String entityType, String entityId) {

        serverAuthzManagementService.deleteEntity(tenantId, entityType, entityId);
        return Response.noContent().build();
    }

    @Override
    public Response authzApiManageV1TTenantIdEntityEntityTypeEntityIdGet(String tenantId, String entityType, String entityId) {

        EntityResponse entityResponse = serverAuthzManagementService.getEntity(tenantId, entityType, entityId);
        return Response.ok().entity(entityResponse).build();
    }

    @Override
    public Response authzApiManageV1TTenantIdEntityPost(String tenantId, CreationEntityRequestModel creationEntityRequestModel) {

        EntityResponse entityResponse = serverAuthzManagementService.createEntity(tenantId, creationEntityRequestModel);
        return Response.ok().entity(entityResponse).build();
    }
}
