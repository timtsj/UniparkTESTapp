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
import com.tsdreamdeveloper.uniparktestapp.di.modules.SharedPrefsHelper;
import com.tsdreamdeveloper.uniparktestapp.mvp.model.AuthResponse;
import com.tsdreamdeveloper.uniparktestapp.mvp.model.Datum;
import com.tsdreamdeveloper.uniparktestapp.mvp.model.TransportsRequest;
import com.tsdreamdeveloper.uniparktestapp.mvp.model.TransportsResponse;
import com.tsdreamdeveloper.uniparktestapp.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

import static com.tsdreamdeveloper.uniparktestapp.common.Utils.BEARER;
import static com.tsdreamdeveloper.uniparktestapp.common.Utils.RESULT_SUCCESS_CODE;

/**
 * @author Timur Seisembayev
 * @since 22.07.2019
 */

@InjectViewState
public class MainPresenter extends BasePresenter<MainView> {

    @Inject
    UniparkService uniparkService;

    @Inject
    SharedPrefsHelper sharedPrefsHelper;

    public MainPresenter() {
        UniparkApp.getAppComponent().inject(this);
    }

    public void getTransports() {
        getViewState().onLoadingStart();
        TransportsRequest request = new TransportsRequest();
        request.setCityId(1);
        request.setTransportTypeId(18);
        //String token = "Bearer " + sharedPrefsHelper.getUser().getAccessToken();

        Disposable subscription = uniparkService
                .getTransports(request)
                .compose(rxUtils.applySchedulers())
                .subscribe(success -> {
                    resultQuit(success);
                }, throwable -> {
                    getViewState().onLoadingFinish();
                    getViewState().showMessage(throwable.getMessage());
                });
        unsubscribeOnDestroy(subscription);
    }

    private void resultQuit(TransportsResponse response) {
        int result = response.getStatus();
        getViewState().onLoadingFinish();
        if (result == RESULT_SUCCESS_CODE) {
            List<Datum> datumList = response.getData();
            getViewState().addList(datumList);
        } else {
            getViewState().showMessage(response.getMessage());
        }
    }

    public void quit() {
        getViewState().onLoadingStart();
        String credentials = BEARER + sharedPrefsHelper.getUser().getAccessToken();
        Disposable subscription = uniparkService
                .quit(credentials)
                .compose(rxUtils.applySchedulers())
                .subscribe(success -> {
                    resultQuit(success);
                }, throwable -> {
                    getViewState().onLoadingFinish();
                    getViewState().showMessage(throwable.getMessage());
                });
        unsubscribeOnDestroy(subscription);
    }

    private void resultQuit(AuthResponse response) {
        int result = response.getStatus();
        getViewState().onLoadingFinish();
        if (result == RESULT_SUCCESS_CODE) {
            sharedPrefsHelper.deleteSavedData(SharedPrefsHelper.PREFS_CURRENT_USER);
            getViewState().nextStep();
        } else {
            getViewState().showMessage(response.getMessage());
        }
    }
}
