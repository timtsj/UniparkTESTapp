
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

public class Data {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("phone_number_additional")
    @Expose
    private Object phoneNumberAdditional;
    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("phone_token")
    @Expose
    private Object phoneToken;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private Object lastname;
    @SerializedName("birth_date")
    @Expose
    private Object birthDate;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("is_driver")
    @Expose
    private Integer isDriver;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("city_id")
    @Expose
    private Integer cityId;
    @SerializedName("city_name")
    @Expose
    private String cityName;
    @SerializedName("company_id")
    @Expose
    private Object companyId;
    @SerializedName("company_name")
    @Expose
    private Object companyName;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("driver_status")
    @Expose
    private Integer driverStatus;
    @SerializedName("transport_status")
    @Expose
    private Integer transportStatus;
    @SerializedName("public")
    @Expose
    private Object _public;
    @SerializedName("user_comment")
    @Expose
    private Object userComment;
    @SerializedName("driver_comment")
    @Expose
    private Object driverComment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Object getPhoneNumberAdditional() {
        return phoneNumberAdditional;
    }

    public void setPhoneNumberAdditional(Object phoneNumberAdditional) {
        this.phoneNumberAdditional = phoneNumberAdditional;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Object getPhoneToken() {
        return phoneToken;
    }

    public void setPhoneToken(Object phoneToken) {
        this.phoneToken = phoneToken;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Object getLastname() {
        return lastname;
    }

    public void setLastname(Object lastname) {
        this.lastname = lastname;
    }

    public Object getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Object birthDate) {
        this.birthDate = birthDate;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Integer getIsDriver() {
        return isDriver;
    }

    public void setIsDriver(Integer isDriver) {
        this.isDriver = isDriver;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Object getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Object companyId) {
        this.companyId = companyId;
    }

    public Object getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Object companyName) {
        this.companyName = companyName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(Integer driverStatus) {
        this.driverStatus = driverStatus;
    }

    public Integer getTransportStatus() {
        return transportStatus;
    }

    public void setTransportStatus(Integer transportStatus) {
        this.transportStatus = transportStatus;
    }

    public Object getPublic() {
        return _public;
    }

    public void setPublic(Object _public) {
        this._public = _public;
    }

    public Object getUserComment() {
        return userComment;
    }

    public void setUserComment(Object userComment) {
        this.userComment = userComment;
    }

    public Object getDriverComment() {
        return driverComment;
    }

    public void setDriverComment(Object driverComment) {
        this.driverComment = driverComment;
    }

}
