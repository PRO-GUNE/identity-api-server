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

/**
 * Result of the entity operation
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "Result of the entity operation")
public class EntityResponse  {
  
    private String entityId;
    private String entityType;
    private String displayName;
    private Object properties;

    /**
    * ID of the entity
    **/
    public EntityResponse entityId(String entityId) {

        this.entityId = entityId;
        return this;
    }
    
    @ApiModelProperty(example = "jane-eyre", value = "ID of the entity")
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
    public EntityResponse entityType(String entityType) {

        this.entityType = entityType;
        return this;
    }
    
    @ApiModelProperty(example = "user", value = "Type of the entity")
    @JsonProperty("entity_type")
    @Valid
    public String getEntityType() {
        return entityType;
    }
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    /**
    * The display name of the entity
    **/
    public EntityResponse displayName(String displayName) {

        this.displayName = displayName;
        return this;
    }
    
    @ApiModelProperty(example = "Jane Eyre", value = "The display name of the entity")
    @JsonProperty("display_name")
    @Valid
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
    * Properties of the entity
    **/
    public EntityResponse properties(Object properties) {

        this.properties = properties;
        return this;
    }
    
    @ApiModelProperty(example = "{\"prop1\":\"value1\",\"prop2\":\"value2\"}", value = "Properties of the entity")
    @JsonProperty("properties")
    @Valid
    public Object getProperties() {
        return properties;
    }
    public void setProperties(Object properties) {
        this.properties = properties;
    }



    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EntityResponse entityResponse = (EntityResponse) o;
        return Objects.equals(this.entityId, entityResponse.entityId) &&
            Objects.equals(this.entityType, entityResponse.entityType) &&
            Objects.equals(this.displayName, entityResponse.displayName) &&
            Objects.equals(this.properties, entityResponse.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entityId, entityType, displayName, properties);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class EntityResponse {\n");
        
        sb.append("    entityId: ").append(toIndentedString(entityId)).append("\n");
        sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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

