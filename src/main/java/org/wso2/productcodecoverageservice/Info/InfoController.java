/*
 *   Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *   WSO2 Inc. licenses this file to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing,
 *   software distributed under the License is distributed on an
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *   KIND, either express or implied.  See the License for the
 *   specific language governing permissions and limitations
 *   under the License.
 */

package org.wso2.productcodecoverageservice.Info;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wso2.productcodecoverageservice.Constants.Info;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class InfoController {

    private static final String serviceInfo = Info.MESSAGE;
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = {Info.GET_REQUEST_INFO}, method = {RequestMethod.GET})
    public org.wso2.productcodecoverageservice.Info.JSONObject.Info introduce() {

        return new org.wso2.productcodecoverageservice.Info.JSONObject.Info(counter.incrementAndGet(),
                String.format(serviceInfo));
    }
}