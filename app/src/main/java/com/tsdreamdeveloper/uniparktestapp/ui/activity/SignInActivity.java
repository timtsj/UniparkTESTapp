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

package com.tsdreamdeveloper.uniparktestapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.tsdreamdeveloper.uniparktestapp.R;
import com.tsdreamdeveloper.uniparktestapp.mvp.presenter.SignInPresenter;
import com.tsdreamdeveloper.uniparktestapp.mvp.view.SignInView;

import static com.tsdreamdeveloper.uniparktestapp.common.Utils.phonePrefix;

/**
 * @author Timur Seisembayev
 * @since 20.07.2019
 */

public class SignInActivity extends BaseActivity implements SignInView {

    @InjectPresenter
    SignInPresenter presenter;

    private EditText mPhone;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mPhone = findViewById(R.id.et_phone);
        mPassword = findViewById(R.id.et_password);
        onSignIn();
        onSignUp();
        phonePrefix(mPhone);
    }

    public void onSignIn() {
        findViewById(R.id.button_sign_in).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = mPhone.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                presenter.setPhone(phone);
                presenter.setPassword(password);
                presenter.login();
            }
        });
    }

    public void onSignUp() {
        findViewById(R.id.button_sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });
    }

    @Override
    public void nextStep() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
