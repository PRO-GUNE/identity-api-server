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

public class DecisionTreeEvaluationRequestIdentityContext  {
  
    private String type;
    private String identity;

    /**
    **/
    public DecisionTreeEvaluationRequestIdentityContext type(String type) {

        this.type = type;
        return this;
    }
    
    @ApiModelProperty(example = "IDENTITY_TYPE_SUB", value = "")
    @JsonProperty("type")
    @Valid
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    /**
    **/
    public DecisionTreeEvaluationRequestIdentityContext identity(String identity) {

        this.identity = identity;
        return this;
    }
    
    @ApiModelProperty(example = "jane@the-eyres.com", value = "")
    @JsonProperty("identity")
    @Valid
    public String getIdentity() {
        return identity;
    }
    public void setIdentity(String identity) {
        this.identity = identity;
    }



    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DecisionTreeEvaluationRequestIdentityContext decisionTreeEvaluationRequestIdentityContext = (DecisionTreeEvaluationRequestIdentityContext) o;
        return Objects.equals(this.type, decisionTreeEvaluationRequestIdentityContext.type) &&
            Objects.equals(this.identity, decisionTreeEvaluationRequestIdentityContext.identity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, identity);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class DecisionTreeEvaluationRequestIdentityContext {\n");
        
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
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
