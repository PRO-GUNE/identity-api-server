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

package org.wso2.carbon.identity.api.server.authz.topaz.common;

import org.wso2.carbon.identity.application.authz.topaz.handler.topaz.TopazAuthzHandler;

/**
 * Service holder class for topaz authorization handler.
 */
public class TopazAuthzServiceHolder {

    private static TopazAuthzHandler topazAuthzHandler;

    /**
     * Get the Topaz Authz handler instance.
     *
     * @return Topaz Authz handler instance
     */
    public static TopazAuthzHandler getTopazAuthzHandler() {
        return topazAuthzHandler;
    }

    /**
     * Set the Topaz Authz Handler instance.
     *
     * @param topazAuthzHandler topazAuthzHandler instance
     */
    public static void setTopazAuthzHandler(TopazAuthzHandler topazAuthzHandler) {
        TopazAuthzServiceHolder.topazAuthzHandler = topazAuthzHandler;
    }
}
