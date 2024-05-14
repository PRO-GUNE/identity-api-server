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
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

/**
 * Policy context of the request
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "Policy context of the request")
public class PolicyEvaluationRequestPolicyContext  {
  
    private List<String> decisions = null;

    private String path;

    /**
    * Set of decisions to be evaluated
    **/
    public PolicyEvaluationRequestPolicyContext decisions(List<String> decisions) {

        this.decisions = decisions;
        return this;
    }
    
    @ApiModelProperty(example = "[\"allowed\",\"enabled\"]", value = "Set of decisions to be evaluated")
    @JsonProperty("decisions")
    @Valid
    public List<String> getDecisions() {
        return decisions;
    }
    public void setDecisions(List<String> decisions) {
        this.decisions = decisions;
    }

    public PolicyEvaluationRequestPolicyContext addDecisionsItem(String decisionsItem) {
        if (this.decisions == null) {
            this.decisions = new ArrayList<>();
        }
        this.decisions.add(decisionsItem);
        return this;
    }

        /**
    * Path of the policy to be evaluated
    **/
    public PolicyEvaluationRequestPolicyContext path(String path) {

        this.path = path;
        return this;
    }
    
    @ApiModelProperty(example = "policy.GET.resource.__id", value = "Path of the policy to be evaluated")
    @JsonProperty("path")
    @Valid
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }



    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PolicyEvaluationRequestPolicyContext policyEvaluationRequestPolicyContext = (PolicyEvaluationRequestPolicyContext) o;
        return Objects.equals(this.decisions, policyEvaluationRequestPolicyContext.decisions) &&
            Objects.equals(this.path, policyEvaluationRequestPolicyContext.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(decisions, path);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class PolicyEvaluationRequestPolicyContext {\n");
        
        sb.append("    decisions: ").append(toIndentedString(decisions)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

