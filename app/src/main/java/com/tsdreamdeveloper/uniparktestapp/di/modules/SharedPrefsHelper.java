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

package com.tsdreamdeveloper.uniparktestapp.di.modules;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.tsdreamdeveloper.uniparktestapp.api.UniparkApp;
import com.tsdreamdeveloper.uniparktestapp.common.Utils;
import com.tsdreamdeveloper.uniparktestapp.mvp.model.User;

/**
 * @author Seisembayev Timur
 * @since 22.07.2019
 */

public class SharedPrefsHelper {

    public static final String PREFS_CURRENT_USER = "CurrentUser";
    private SharedPreferences mSharedPreferences;
    private Context mContext;
    private UniparkApp app;

    public SharedPrefsHelper(SharedPreferences sharedPreferences, Context context) {
        this.mContext = context;
        mSharedPreferences = sharedPreferences;
        app = (UniparkApp) context;
    }

    public void put(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    public void put(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    public void put(String key, float value) {
        mSharedPreferences.edit().putFloat(key, value).apply();
    }

    public void put(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    public String get(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    public Integer get(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    public Float get(String key, float defaultValue) {
        return mSharedPreferences.getFloat(key, defaultValue);
    }

    public Boolean get(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    public void putUser(User user) {
        SharedPreferences.Editor prefsEditor = mSharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        prefsEditor.putString(PREFS_CURRENT_USER, json);
        prefsEditor.apply();
    }

    public User getUser() {
        Gson gson = new Gson();
        String json = mSharedPreferences.getString(PREFS_CURRENT_USER, "");
        User user = gson.fromJson(json, User.class);
        return user;
    }

    public void deleteSavedData(String key) {
        mSharedPreferences.edit().remove(key).apply();
    }

    public boolean containsKey(String key) {
        return mSharedPreferences.contains(key);
    }

}
