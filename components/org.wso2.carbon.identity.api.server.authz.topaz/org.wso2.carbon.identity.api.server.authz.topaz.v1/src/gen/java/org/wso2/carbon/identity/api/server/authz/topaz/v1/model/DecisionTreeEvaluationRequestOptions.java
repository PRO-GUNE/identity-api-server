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

public class DecisionTreeEvaluationRequestOptions  {
  
    private String pathSeparator;

    /**
    **/
    public DecisionTreeEvaluationRequestOptions pathSeparator(String pathSeparator) {

        this.pathSeparator = pathSeparator;
        return this;
    }
    
    @ApiModelProperty(example = "PATH_SEPARATOR_DOT", value = "")
    @JsonProperty("path_separator")
    @Valid
    public String getPathSeparator() {
        return pathSeparator;
    }
    public void setPathSeparator(String pathSeparator) {
        this.pathSeparator = pathSeparator;
    }



    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DecisionTreeEvaluationRequestOptions decisionTreeEvaluationRequestOptions = (DecisionTreeEvaluationRequestOptions) o;
        return Objects.equals(this.pathSeparator, decisionTreeEvaluationRequestOptions.pathSeparator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pathSeparator);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class DecisionTreeEvaluationRequestOptions {\n");
        
        sb.append("    pathSeparator: ").append(toIndentedString(pathSeparator)).append("\n");
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

