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
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.CreationEntityRequestModel;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.CreationRelationRequestModel;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.EntityResponse;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.RelationResponse;
import org.wso2.carbon.identity.application.authz.topaz.handler.core.DirectoryEntityResponse;
import org.wso2.carbon.identity.application.authz.topaz.handler.core.DirectoryRelationResponse;
import org.wso2.carbon.identity.application.authz.topaz.handler.topaz.TopazAuthzHandler;

import static org.wso2.carbon.identity.api.server.authz.topaz.common.Constants.JOIN_SYMBOL;

/**
 * Class to handle the implementation of the authorization management endpoints.
 */
public class ServerAuthzManagementService {

    public EntityResponse getEntity(String tenantId, String entityType, String entityId) {

        String id = tenantId + JOIN_SYMBOL + entityId;
        TopazAuthzHandler topazAuthzHandler = TopazAuthzServiceHolder.getTopazAuthzHandler();

        DirectoryEntityResponse directoryEntityResponse = topazAuthzHandler.getTopazManagementHandler().getEntity(
                topazAuthzHandler.getObjManagementHandler().createDirectoryObject(entityType, id));

        EntityResponse entityResponse = new EntityResponse();
        entityResponse.setEntityId(directoryEntityResponse.getEntityId());
        entityResponse.setEntityType(directoryEntityResponse.getEntityType());
        entityResponse.setDisplayName(directoryEntityResponse.getDisplayName());
        entityResponse.setProperties(directoryEntityResponse.getProperties());

        return entityResponse;
    }

    public EntityResponse createEntity(String tenantId, CreationEntityRequestModel creationEntityRequestModel) {

        String id = tenantId + JOIN_SYMBOL + creationEntityRequestModel.getEntityId();
        TopazAuthzHandler topazAuthzHandler = TopazAuthzServiceHolder.getTopazAuthzHandler();

        DirectoryEntityResponse directoryEntityResponse = topazAuthzHandler.getTopazManagementHandler().getEntity(
                topazAuthzHandler.getObjManagementHandler().createDirectoryObject(
                        creationEntityRequestModel.getDisplayName(),
                        creationEntityRequestModel.getEntityType(),
                        id,
                        creationEntityRequestModel.getProperties()));

        EntityResponse entityResponse = new EntityResponse();
        entityResponse.setEntityId(directoryEntityResponse.getEntityId());
        entityResponse.setEntityType(directoryEntityResponse.getEntityType());
        entityResponse.setDisplayName(directoryEntityResponse.getDisplayName());
        entityResponse.setProperties(directoryEntityResponse.getProperties());

        return entityResponse;
    }

    public void deleteEntity(String tenantId, String entityType, String entityId) {

        String id = tenantId + JOIN_SYMBOL + entityId;
        TopazAuthzHandler topazAuthzHandler = TopazAuthzServiceHolder.getTopazAuthzHandler();

        topazAuthzHandler.getTopazManagementHandler().deleteEntity(topazAuthzHandler.getObjManagementHandler().
                createDirectoryObject(entityType, id));
    }

    public RelationResponse getRelation(String tenantId, String entityType, String entityId, String relation,
                                        String subjectType, String subjectId, String subjectRelation) {

        String tSubjectId = tenantId + JOIN_SYMBOL + subjectId;
        String tEntityId = tenantId + JOIN_SYMBOL + entityId;
        TopazAuthzHandler topazAuthzHandler = TopazAuthzServiceHolder.getTopazAuthzHandler();

        DirectoryRelationResponse directoryRelationResponse = topazAuthzHandler.getTopazManagementHandler().getRelation(
                topazAuthzHandler.getObjManagementHandler().createDirectoryRelation(
                        tEntityId, entityType, relation, tSubjectId, subjectType, subjectRelation));

        RelationResponse relationResponse = new RelationResponse();
        relationResponse.setEntityId(directoryRelationResponse.getEntityId());
        relationResponse.setEntityType(directoryRelationResponse.getEntityType());
        relationResponse.setRelation(directoryRelationResponse.getRelation());
        relationResponse.setSubjectId(directoryRelationResponse.getSubjectId());
        relationResponse.setSubjectType(directoryRelationResponse.getSubjectType());
        relationResponse.setSubjectRelation(directoryRelationResponse.getSubjectRelation());

        return relationResponse;
    }

    public RelationResponse createRelation(String tenantId, CreationRelationRequestModel creationRelationRequestModel) {
        String tSubjectId = tenantId + JOIN_SYMBOL + creationRelationRequestModel.getSubjectId();
        String tEntityId = tenantId + JOIN_SYMBOL + creationRelationRequestModel.getEntityId();
        TopazAuthzHandler topazAuthzHandler = TopazAuthzServiceHolder.getTopazAuthzHandler();

        DirectoryRelationResponse directoryRelationResponse = topazAuthzHandler.getTopazManagementHandler().getRelation(
                topazAuthzHandler.getObjManagementHandler().createDirectoryRelation(
                        tEntityId,
                        creationRelationRequestModel.getEntityType(),
                        creationRelationRequestModel.getRelation(),
                        tSubjectId,
                        creationRelationRequestModel.getSubjectType(),
                        creationRelationRequestModel.getSubjectRelation()));

        RelationResponse relationResponse = new RelationResponse();
        relationResponse.setEntityId(directoryRelationResponse.getEntityId());
        relationResponse.setEntityType(directoryRelationResponse.getEntityType());
        relationResponse.setRelation(directoryRelationResponse.getRelation());
        relationResponse.setSubjectId(directoryRelationResponse.getSubjectId());
        relationResponse.setSubjectType(directoryRelationResponse.getSubjectType());
        relationResponse.setSubjectRelation(directoryRelationResponse.getSubjectRelation());

        return relationResponse;
    }

    public void deleteRelation(String tenantId, String entityType, String entityId, String relation,
                               String subjectType, String subjectId, String subjectRelation) {

        String tSubjectId = tenantId + JOIN_SYMBOL + subjectId;
        String tEntityId = tenantId + JOIN_SYMBOL + entityId;
        TopazAuthzHandler topazAuthzHandler = TopazAuthzServiceHolder.getTopazAuthzHandler();

        topazAuthzHandler.getTopazManagementHandler().deleteRelation(topazAuthzHandler.getObjManagementHandler().
                createDirectoryRelation(tEntityId, entityType, relation, tSubjectId, subjectType, subjectRelation));
    }
}
