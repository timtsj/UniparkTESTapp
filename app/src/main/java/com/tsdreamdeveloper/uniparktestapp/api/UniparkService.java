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

package com.tsdreamdeveloper.uniparktestapp.api;

import com.tsdreamdeveloper.uniparktestapp.mvp.model.AuthRequest;
import com.tsdreamdeveloper.uniparktestapp.mvp.model.AuthResponse;
import com.tsdreamdeveloper.uniparktestapp.mvp.model.RegistrationRequest;
import com.tsdreamdeveloper.uniparktestapp.mvp.model.TransportsRequest;
import com.tsdreamdeveloper.uniparktestapp.mvp.model.TransportsResponse;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * @author Timur Seisembayev
 * @since 20.07.2019
 */
public class UniparkService {

    private UniparkApi api;

    public UniparkService(UniparkApi api) {
        this.api = api;
    }

    public Single<AuthResponse> signIn(AuthRequest request) {
        return api.signIn(request);
    }

    public Single<AuthResponse> signUp(RegistrationRequest request) {
        return api.signUp(request);
    }

    public Single<TransportsResponse> getTransports(String token, TransportsRequest request) {
        return api.getTransports(token, request);
    }

    public Single<AuthResponse> quit(String token) {
        return api.quit(token);
    }
}
