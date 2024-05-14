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
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.DecisionTreeEvaluationRequestIdentityContext;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.DecisionTreeEvaluationRequestOptions;
import org.wso2.carbon.identity.api.server.authz.topaz.v1.model.DecisionTreeEvaluationRequestPolicyContext;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;

public class DecisionTreeEvaluationRequest  {
  
    private DecisionTreeEvaluationRequestIdentityContext identityContext;
    private DecisionTreeEvaluationRequestOptions options;
    private Object resourceContext;
    private DecisionTreeEvaluationRequestPolicyContext policyContext;

    /**
    **/
    public DecisionTreeEvaluationRequest identityContext(DecisionTreeEvaluationRequestIdentityContext identityContext) {

        this.identityContext = identityContext;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("identity_context")
    @Valid
    public DecisionTreeEvaluationRequestIdentityContext getIdentityContext() {
        return identityContext;
    }
    public void setIdentityContext(DecisionTreeEvaluationRequestIdentityContext identityContext) {
        this.identityContext = identityContext;
    }

    /**
    **/
    public DecisionTreeEvaluationRequest options(DecisionTreeEvaluationRequestOptions options) {

        this.options = options;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("options")
    @Valid
    public DecisionTreeEvaluationRequestOptions getOptions() {
        return options;
    }
    public void setOptions(DecisionTreeEvaluationRequestOptions options) {
        this.options = options;
    }

    /**
    **/
    public DecisionTreeEvaluationRequest resourceContext(Object resourceContext) {

        this.resourceContext = resourceContext;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("resource_context")
    @Valid
    public Object getResourceContext() {
        return resourceContext;
    }
    public void setResourceContext(Object resourceContext) {
        this.resourceContext = resourceContext;
    }

    /**
    **/
    public DecisionTreeEvaluationRequest policyContext(DecisionTreeEvaluationRequestPolicyContext policyContext) {

        this.policyContext = policyContext;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("policy_context")
    @Valid
    public DecisionTreeEvaluationRequestPolicyContext getPolicyContext() {
        return policyContext;
    }
    public void setPolicyContext(DecisionTreeEvaluationRequestPolicyContext policyContext) {
        this.policyContext = policyContext;
    }



    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DecisionTreeEvaluationRequest decisionTreeEvaluationRequest = (DecisionTreeEvaluationRequest) o;
        return Objects.equals(this.identityContext, decisionTreeEvaluationRequest.identityContext) &&
            Objects.equals(this.options, decisionTreeEvaluationRequest.options) &&
            Objects.equals(this.resourceContext, decisionTreeEvaluationRequest.resourceContext) &&
            Objects.equals(this.policyContext, decisionTreeEvaluationRequest.policyContext);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identityContext, options, resourceContext, policyContext);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class DecisionTreeEvaluationRequest {\n");
        
        sb.append("    identityContext: ").append(toIndentedString(identityContext)).append("\n");
        sb.append("    options: ").append(toIndentedString(options)).append("\n");
        sb.append("    resourceContext: ").append(toIndentedString(resourceContext)).append("\n");
        sb.append("    policyContext: ").append(toIndentedString(policyContext)).append("\n");
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

