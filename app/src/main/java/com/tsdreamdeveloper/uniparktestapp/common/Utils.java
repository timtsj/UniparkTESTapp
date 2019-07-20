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

package com.tsdreamdeveloper.uniparktestapp.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * @author Timur Seisembayev
 * @since 20.07.2019
 */

public class Utils {

    public static final String BASE_URL = "https://testapi.unipark.kz/v2/";
    public static final String SIGN_UP = "users";
    public static final String SIGN_IN = "users/auth";
    public static final int RESULT_SUCCESS_CODE = 200;

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void phonePrefix(EditText editText) {
        editText.setText("+7");
        Selection.setSelection(editText.getText(), editText.getText().length());
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().startsWith("+7")) {
                    editText.setText("+7");
                    Selection.setSelection(editText.getText(), editText.getText().length());
                }
            }
        });
    }
}
