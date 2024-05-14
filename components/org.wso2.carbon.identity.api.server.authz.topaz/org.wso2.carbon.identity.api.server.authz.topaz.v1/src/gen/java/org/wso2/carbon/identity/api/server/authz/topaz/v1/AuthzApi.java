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

import org.springframework.beans.factory.annotation.Autowired;
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
import org.wso2.carbon.identity.api.server.authz.topaz.v1.AuthzApiService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import io.swagger.annotations.*;

import javax.validation.constraints.*;

@Path("/authz")
@Api(description = "The authz API")

public class AuthzApi  {

    @Autowired
    private AuthzApiService delegate;

    @Valid
    @POST
    @Path("/api/eval/v1/t/{tenant_id}/check")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Perform access check", notes = "", response = AccessCheckResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful access check", response = AccessCheckResponse.class),
        @ApiResponse(code = 400, message = "Bad request", response = Error.class)
    })
    public Response authzApiEvalV1TTenantIdCheckPost(@ApiParam(value = "Tenant ID",required=true) @PathParam("tenant_id") String tenantId, @ApiParam(value = "" ,required=true) @Valid AccessCheckRequest accessCheckRequest) {

        return delegate.authzApiEvalV1TTenantIdCheckPost(tenantId,  accessCheckRequest );
    }

    @Valid
    @POST
    @Path("/api/eval/v1/t/{tenant_id}/decisiontree")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Evaluate multiple policies", notes = "", response = DecisionTreeEvaluationResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful decision tree evaluation", response = DecisionTreeEvaluationResponse.class),
        @ApiResponse(code = 400, message = "Bad request", response = Error.class)
    })
    public Response authzApiEvalV1TTenantIdDecisiontreePost(@ApiParam(value = "Tenant ID",required=true) @PathParam("tenant_id") String tenantId, @ApiParam(value = "" ,required=true) @Valid DecisionTreeEvaluationRequest decisionTreeEvaluationRequest) {

        return delegate.authzApiEvalV1TTenantIdDecisiontreePost(tenantId,  decisionTreeEvaluationRequest );
    }

    @Valid
    @POST
    @Path("/api/eval/v1/t/{tenant_id}/graph")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Generate graph", notes = "", response = GraphGenerationResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful graph generation", response = GraphGenerationResponse.class),
        @ApiResponse(code = 400, message = "Bad request", response = Error.class)
    })
    public Response authzApiEvalV1TTenantIdGraphPost(@ApiParam(value = "Tenant ID",required=true) @PathParam("tenant_id") String tenantId, @ApiParam(value = "" ,required=true) @Valid GraphGenerationRequest graphGenerationRequest) {

        return delegate.authzApiEvalV1TTenantIdGraphPost(tenantId,  graphGenerationRequest );
    }

    @Valid
    @POST
    @Path("/api/eval/v1/t/{tenant_id}/policy")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Evaluate a single policy", notes = "", response = PolicyEvaluationResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful policy evaluation", response = PolicyEvaluationResponse.class),
        @ApiResponse(code = 400, message = "Bad request", response = Error.class)
    })
    public Response authzApiEvalV1TTenantIdPolicyPost(@ApiParam(value = "Tenant ID",required=true) @PathParam("tenant_id") String tenantId, @ApiParam(value = "" ,required=true) @Valid PolicyEvaluationRequest policyEvaluationRequest) {

        return delegate.authzApiEvalV1TTenantIdPolicyPost(tenantId,  policyEvaluationRequest );
    }

    @Valid
    @DELETE
    @Path("/api/manage/v1/t/{tenant_id}/entity/{entity_type}/{entity_id}")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Delete an entity.", notes = "", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Successful entity deletion", response = Void.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class)
    })
    public Response authzApiManageV1TTenantIdEntityEntityTypeEntityIdDelete(@ApiParam(value = "Tenant ID",required=true) @PathParam("tenant_id") String tenantId, @ApiParam(value = "Entity type",required=true) @PathParam("entity_type") String entityType, @ApiParam(value = "Entity ID",required=true) @PathParam("entity_id") String entityId) {

        return delegate.authzApiManageV1TTenantIdEntityEntityTypeEntityIdDelete(tenantId,  entityType,  entityId );
    }

    @Valid
    @GET
    @Path("/api/manage/v1/t/{tenant_id}/entity/{entity_type}/{entity_id}")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get an entity.", notes = "", response = EntityResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful entity retrieval", response = EntityResponse.class),
        @ApiResponse(code = 404, message = "Entity not found", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    public Response authzApiManageV1TTenantIdEntityEntityTypeEntityIdGet(@ApiParam(value = "Tenant ID",required=true) @PathParam("tenant_id") String tenantId, @ApiParam(value = "Entity type",required=true) @PathParam("entity_type") String entityType, @ApiParam(value = "Entity ID",required=true) @PathParam("entity_id") String entityId) {

        return delegate.authzApiManageV1TTenantIdEntityEntityTypeEntityIdGet(tenantId,  entityType,  entityId );
    }

    @Valid
    @POST
    @Path("/api/manage/v1/t/{tenant_id}/entity")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Create an entity.", notes = "", response = EntityResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful entity creation", response = EntityResponse.class),
        @ApiResponse(code = 400, message = "Bad request", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    public Response authzApiManageV1TTenantIdEntityPost(@ApiParam(value = "Tenant ID",required=true) @PathParam("tenant_id") String tenantId, @ApiParam(value = "" ,required=true) @Valid CreationEntityRequestModel creationEntityRequestModel) {

        return delegate.authzApiManageV1TTenantIdEntityPost(tenantId,  creationEntityRequestModel );
    }

    @Valid
    @DELETE
    @Path("/api/manage/v1/t/{tenant_id}/relation")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Delete a relation.", notes = "", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Successful relation deletion", response = Void.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class)
    })
    public Response authzApiManageV1TTenantIdRelationDelete(@ApiParam(value = "Tenant ID",required=true) @PathParam("tenant_id") String tenantId,     @Valid @NotNull(message = "Property  cannot be null.") @ApiParam(value = "Entity type",required=true)  @QueryParam("entity_type") String entityType,     @Valid @NotNull(message = "Property  cannot be null.") @ApiParam(value = "Entity ID",required=true)  @QueryParam("entity_id") String entityId,     @Valid @NotNull(message = "Property  cannot be null.") @ApiParam(value = "Relation",required=true)  @QueryParam("relation") String relation,     @Valid @NotNull(message = "Property  cannot be null.") @ApiParam(value = "Subject type",required=true)  @QueryParam("subject_type") String subjectType,     @Valid @NotNull(message = "Property  cannot be null.") @ApiParam(value = "Subject ID",required=true)  @QueryParam("subject_id") String subjectId,     @Valid @NotNull(message = "Property  cannot be null.") @ApiParam(value = "Subject relation",required=true)  @QueryParam("subject_relation") String subjectRelation) {

        return delegate.authzApiManageV1TTenantIdRelationDelete(tenantId,  entityType,  entityId,  relation,  subjectType,  subjectId,  subjectRelation );
    }

    @Valid
    @GET
    @Path("/api/manage/v1/t/{tenant_id}/relation")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get a relation.", notes = "", response = RelationResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful relation retrieval", response = RelationResponse.class),
        @ApiResponse(code = 404, message = "Relation not found", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    public Response authzApiManageV1TTenantIdRelationGet(@ApiParam(value = "Tenant ID",required=true) @PathParam("tenant_id") String tenantId,     @Valid @NotNull(message = "Property  cannot be null.") @ApiParam(value = "Entity type",required=true)  @QueryParam("entity_type") String entityType,     @Valid @NotNull(message = "Property  cannot be null.") @ApiParam(value = "Entity ID",required=true)  @QueryParam("entity_id") String entityId,     @Valid @NotNull(message = "Property  cannot be null.") @ApiParam(value = "Relation",required=true)  @QueryParam("relation") String relation,     @Valid @NotNull(message = "Property  cannot be null.") @ApiParam(value = "Subject type",required=true)  @QueryParam("subject_type") String subjectType,     @Valid @NotNull(message = "Property  cannot be null.") @ApiParam(value = "Subject ID",required=true)  @QueryParam("subject_id") String subjectId,     @Valid @NotNull(message = "Property  cannot be null.") @ApiParam(value = "Subject relation",required=true)  @QueryParam("subject_relation") String subjectRelation) {

        return delegate.authzApiManageV1TTenantIdRelationGet(tenantId,  entityType,  entityId,  relation,  subjectType,  subjectId,  subjectRelation );
    }

    @Valid
    @POST
    @Path("/api/manage/v1/t/{tenant_id}/relation")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Create a relation.", notes = "", response = RelationResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful relation creation", response = RelationResponse.class),
        @ApiResponse(code = 400, message = "Bad request", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    public Response authzApiManageV1TTenantIdRelationPost(@ApiParam(value = "Tenant ID",required=true) @PathParam("tenant_id") String tenantId, @ApiParam(value = "" ,required=true) @Valid CreationRelationRequestModel creationRelationRequestModel) {

        return delegate.authzApiManageV1TTenantIdRelationPost(tenantId,  creationRelationRequestModel );
    }

}
