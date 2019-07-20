
/*
 * Copyright 2019 TSDream Developer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tsdreamdeveloper.uniparktestapp.mvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Timur Seisembayev
 * @since 20.07.2019
 */

public class AuthRequest {

    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("phone_type")
    @Expose
    private Integer phoneType;
    @SerializedName("phone_token")
    @Expose
    private String phoneToken;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(Integer phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneToken() {
        return phoneToken;
    }

    public void setPhoneToken(String phoneToken) {
        this.phoneToken = phoneToken;
    }

}
