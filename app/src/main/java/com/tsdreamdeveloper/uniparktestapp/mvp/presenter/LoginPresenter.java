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
import com.tsdreamdeveloper.uniparktestapp.mvp.model.AuthRequest;
import com.tsdreamdeveloper.uniparktestapp.mvp.model.AuthResponse;
import com.tsdreamdeveloper.uniparktestapp.mvp.view.LoginView;

import javax.inject.Inject;

import rx.Subscription;

import static com.tsdreamdeveloper.uniparktestapp.common.Utils.RESULT_SUCCESS_CODE;

/**
 * @author Timur Seisembayev
 * @since 20.07.2019
 */

@InjectViewState
public class LoginPresenter extends BasePresenter<LoginView> {

    private static final int PHONE_TYPE = 1;
    private static final String PHONE_TOKEN = "token";

    @Inject
    UniparkService uniparkService;

    private String phone;
    private String password;

    public LoginPresenter() {
        UniparkApp.getAppComponent().inject(this);
    }

    public void login() {
        getViewState().onLoadingStart();
        AuthRequest request = new AuthRequest();
        request.setPhoneNumber(phone);
        request.setPassword(password);
        request.setPhoneToken(PHONE_TOKEN);
        request.setPhoneType(PHONE_TYPE);

        Subscription subscription = uniparkService
                .login(request)
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
           getViewState().nextStep();
        } else {
            getViewState().showMessage(response.getMessage());
        }
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
