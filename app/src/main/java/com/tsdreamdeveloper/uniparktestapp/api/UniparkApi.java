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

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

import static com.tsdreamdeveloper.uniparktestapp.common.Utils.SIGN_IN;
import static com.tsdreamdeveloper.uniparktestapp.common.Utils.SIGN_UP;

/**
 * @author Timur Seisembayev
 * @since 20.07.2019
 */
public interface UniparkApi {

    @Headers("api-version: 21")
    @POST(SIGN_IN)
    Observable<AuthResponse> login(@Body AuthRequest body);

    @Headers("api-version: 21")
    @POST(SIGN_UP)
    Observable<AuthResponse> registration(@Body RegistrationRequest body);
}
