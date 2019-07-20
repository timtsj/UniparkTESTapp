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

package com.tsdreamdeveloper.uniparktestapp.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.tsdreamdeveloper.uniparktestapp.api.UniparkApp;
import com.tsdreamdeveloper.uniparktestapp.api.UniparkService;
import com.tsdreamdeveloper.uniparktestapp.common.rxUtils;
import com.tsdreamdeveloper.uniparktestapp.mvp.model.AuthResponse;
import com.tsdreamdeveloper.uniparktestapp.mvp.model.RegistrationRequest;
import com.tsdreamdeveloper.uniparktestapp.mvp.view.RegistrationView;

import javax.inject.Inject;

import rx.Subscription;

import static com.tsdreamdeveloper.uniparktestapp.common.Utils.RESULT_SUCCESS_CODE;

/**
 * @author Timur Seisembayev
 * @since 20.07.2019
 */

@InjectViewState
public class RegistrationPresenter extends BasePresenter<RegistrationView> {

    private static final int CITY_ID = 1;
    private static final int IS_DRIVER = 0;
    public static final String MESSAGE = "Success";

    @Inject
    UniparkService uniparkService;

    private String phone;
    private String firstname;

    public RegistrationPresenter() {
        UniparkApp.getAppComponent().inject(this);
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void registration() {
        getViewState().onLoadingStart();
        RegistrationRequest request = new RegistrationRequest();
        request.setCityId(CITY_ID);
        request.setFirstname(firstname);
        request.setIsDriver(IS_DRIVER);
        request.setPhoneNumber(phone);

        Subscription subscription = uniparkService
                .registration(request)
                .compose(rxUtils.applySchedulers())
                .subscribe(success -> {
                    result(success);
                }, throwable -> {
                    getViewState().onLoadingFinish();
                    getViewState().showMessage(throwable.getMessage());
                });
        unsubscribeOnDestroy(subscription);
    }

    private void result(AuthResponse response) {
        int result = response.getStatus();
        getViewState().onLoadingFinish();

        if (result == RESULT_SUCCESS_CODE) {
            getViewState().showMessage(MESSAGE);
        } else {
            getViewState().showMessage(response.getMessage());
        }
    }
}
