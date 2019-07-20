
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

import java.util.Objects;

/**
 * @author Timur Seisembayev
 * @since 20.07.2019
 */

public class RegistrationRequest {

    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("city_id")
    @Expose
    private Integer cityId;
    @SerializedName("is_driver")
    @Expose
    private Integer isDriver;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getIsDriver() {
        return isDriver;
    }

    public void setIsDriver(Integer isDriver) {
        this.isDriver = isDriver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationRequest that = (RegistrationRequest) o;
        return Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(cityId, that.cityId) &&
                Objects.equals(isDriver, that.isDriver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, firstname, cityId, isDriver);
    }

    @Override
    public String toString() {
        return "RegistrationRequest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", firstname='" + firstname + '\'' +
                ", cityId=" + cityId +
                ", isDriver=" + isDriver +
                '}';
    }
}
