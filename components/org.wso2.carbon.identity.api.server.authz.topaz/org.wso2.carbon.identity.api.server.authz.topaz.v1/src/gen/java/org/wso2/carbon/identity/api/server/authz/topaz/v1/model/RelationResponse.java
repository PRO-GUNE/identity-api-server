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

package org.wso2.carbon.identity.api.server.authz.topaz.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;

public class RelationResponse  {
  
    private String subjectId;
    private String subjectRelation;
    private String subjectType;
    private String entityId;
    private String entityType;
    private String relation;

    /**
    * ID of the subject
    **/
    public RelationResponse subjectId(String subjectId) {

        this.subjectId = subjectId;
        return this;
    }
    
    @ApiModelProperty(example = "user123", value = "ID of the subject")
    @JsonProperty("subject_id")
    @Valid
    public String getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    /**
    * Relation of the subject
    **/
    public RelationResponse subjectRelation(String subjectRelation) {

        this.subjectRelation = subjectRelation;
        return this;
    }
    
    @ApiModelProperty(example = "manager", value = "Relation of the subject")
    @JsonProperty("subject_relation")
    @Valid
    public String getSubjectRelation() {
        return subjectRelation;
    }
    public void setSubjectRelation(String subjectRelation) {
        this.subjectRelation = subjectRelation;
    }

    /**
    * Type of the subject
    **/
    public RelationResponse subjectType(String subjectType) {

        this.subjectType = subjectType;
        return this;
    }
    
    @ApiModelProperty(example = "user", value = "Type of the subject")
    @JsonProperty("subject_type")
    @Valid
    public String getSubjectType() {
        return subjectType;
    }
    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    /**
    * ID of the entity
    **/
    public RelationResponse entityId(String entityId) {

        this.entityId = entityId;
        return this;
    }
    
    @ApiModelProperty(example = "resource456", value = "ID of the entity")
    @JsonProperty("entity_id")
    @Valid
    public String getEntityId() {
        return entityId;
    }
    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    /**
    * Type of the entity
    **/
    public RelationResponse entityType(String entityType) {

        this.entityType = entityType;
        return this;
    }
    
    @ApiModelProperty(example = "resource", value = "Type of the entity")
    @JsonProperty("entity_type")
    @Valid
    public String getEntityType() {
        return entityType;
    }
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    /**
    * Relation between the subject and entity
    **/
    public RelationResponse relation(String relation) {

        this.relation = relation;
        return this;
    }
    
    @ApiModelProperty(example = "owns", value = "Relation between the subject and entity")
    @JsonProperty("relation")
    @Valid
    public String getRelation() {
        return relation;
    }
    public void setRelation(String relation) {
        this.relation = relation;
    }



    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RelationResponse relationResponse = (RelationResponse) o;
        return Objects.equals(this.subjectId, relationResponse.subjectId) &&
            Objects.equals(this.subjectRelation, relationResponse.subjectRelation) &&
            Objects.equals(this.subjectType, relationResponse.subjectType) &&
            Objects.equals(this.entityId, relationResponse.entityId) &&
            Objects.equals(this.entityType, relationResponse.entityType) &&
            Objects.equals(this.relation, relationResponse.relation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, subjectRelation, subjectType, entityId, entityType, relation);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class RelationResponse {\n");
        
        sb.append("    subjectId: ").append(toIndentedString(subjectId)).append("\n");
        sb.append("    subjectRelation: ").append(toIndentedString(subjectRelation)).append("\n");
        sb.append("    subjectType: ").append(toIndentedString(subjectType)).append("\n");
        sb.append("    entityId: ").append(toIndentedString(entityId)).append("\n");
        sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
        sb.append("    relation: ").append(toIndentedString(relation)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
    * Convert the given object to string with each line indented by 4 spaces
    * (except the first line).
    */
    private String toIndentedString(java.lang.Object o) {

        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n");
    }
}

