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
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.AccessCheckRequestRelation;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.AccessCheckRequestResource;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.AccessCheckRequestSubject;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;

public class GraphGenerationRequest  {
  
    private AccessCheckRequestSubject subject;
    private AccessCheckRequestResource resource;
    private AccessCheckRequestRelation relation;

    /**
    **/
    public GraphGenerationRequest subject(AccessCheckRequestSubject subject) {

        this.subject = subject;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("subject")
    @Valid
    public AccessCheckRequestSubject getSubject() {
        return subject;
    }
    public void setSubject(AccessCheckRequestSubject subject) {
        this.subject = subject;
    }

    /**
    **/
    public GraphGenerationRequest resource(AccessCheckRequestResource resource) {

        this.resource = resource;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("resource")
    @Valid
    public AccessCheckRequestResource getResource() {
        return resource;
    }
    public void setResource(AccessCheckRequestResource resource) {
        this.resource = resource;
    }

    /**
    **/
    public GraphGenerationRequest relation(AccessCheckRequestRelation relation) {

        this.relation = relation;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("relation")
    @Valid
    public AccessCheckRequestRelation getRelation() {
        return relation;
    }
    public void setRelation(AccessCheckRequestRelation relation) {
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
        GraphGenerationRequest graphGenerationRequest = (GraphGenerationRequest) o;
        return Objects.equals(this.subject, graphGenerationRequest.subject) &&
            Objects.equals(this.resource, graphGenerationRequest.resource) &&
            Objects.equals(this.relation, graphGenerationRequest.relation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, resource, relation);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class GraphGenerationRequest {\n");
        
        sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
        sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
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

