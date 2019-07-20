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

import rx.Observable;

/**
 * @author Timur Seisembayev
 * @since 20.07.2019
 */
public class UniparkService {

    private UniparkApi api;

    public UniparkService(UniparkApi api) {
        this.api = api;
    }

    public Observable<AuthResponse> login(AuthRequest request) {
        return api.login(request);
    }

    public Observable<AuthResponse> registration(RegistrationRequest request) {
        return api.registration(request);
    }
}
