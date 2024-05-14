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

package org.wso2.carbon.identity.api.server.authz.topaz.v1;

import org.wso2.carbon.identity.api.server.authz.topaz.v1.*;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.*;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import java.io.InputStream;
import java.util.List;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.AccessCheckRequest;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.AccessCheckResponse;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.CreationEntityRequestModel;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.CreationRelationRequestModel;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.DecisionTreeEvaluationRequest;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.DecisionTreeEvaluationResponse;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.EntityResponse;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.Error;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.GraphGenerationRequest;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.GraphGenerationResponse;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.PolicyEvaluationRequest;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.PolicyEvaluationResponse;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.RelationResponse;
import javax.ws.rs.core.Response;


public interface AuthzApiService {

      public Response authzApiEvalV1TTenantIdCheckPost(String tenantId, AccessCheckRequest accessCheckRequest);

      public Response authzApiEvalV1TTenantIdDecisiontreePost(String tenantId, DecisionTreeEvaluationRequest decisionTreeEvaluationRequest);

      public Response authzApiEvalV1TTenantIdGraphPost(String tenantId, GraphGenerationRequest graphGenerationRequest);

      public Response authzApiEvalV1TTenantIdPolicyPost(String tenantId, PolicyEvaluationRequest policyEvaluationRequest);

      public Response authzApiManageV1TTenantIdEntityEntityTypeEntityIdDelete(String tenantId, String entityType, String entityId);

      public Response authzApiManageV1TTenantIdEntityEntityTypeEntityIdGet(String tenantId, String entityType, String entityId);

      public Response authzApiManageV1TTenantIdEntityPost(String tenantId, CreationEntityRequestModel creationEntityRequestModel);

      public Response authzApiManageV1TTenantIdRelationDelete(String tenantId, String entityType, String entityId, String relation, String subjectType, String subjectId, String subjectRelation);

      public Response authzApiManageV1TTenantIdRelationGet(String tenantId, String entityType, String entityId, String relation, String subjectType, String subjectId, String subjectRelation);

      public Response authzApiManageV1TTenantIdRelationPost(String tenantId, CreationRelationRequestModel creationRelationRequestModel);
}
