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

package com.tsdreamdeveloper.uniparktestapp.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.tsdreamdeveloper.uniparktestapp.R;
import com.tsdreamdeveloper.uniparktestapp.mvp.presenter.LoginPresenter;
import com.tsdreamdeveloper.uniparktestapp.mvp.view.LoginView;
import com.tsdreamdeveloper.uniparktestapp.ui.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.tsdreamdeveloper.uniparktestapp.common.Utils.phonePrefix;

/**
 * @author Timur Seisembayev
 * @since 20.07.2019
 */
public class LoginFragment extends BaseFragment implements LoginView {

    @InjectPresenter
    LoginPresenter presenter;

    @BindView(R.id.et_phone)
    EditText mPhone;

    @BindView(R.id.et_password)
    EditText mPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        phonePrefix(mPhone);
    }

    @OnClick(R.id.button_login)
    public void onSignIn() {
        String phone = mPhone.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        presenter.setPhone(phone);
        presenter.setPassword(password);
        presenter.login();
    }

    @OnClick(R.id.button_registration)
    public void onSignUp() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        RegistrationFragment fragment = new RegistrationFragment();
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    @Override
    public void nextStep() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
