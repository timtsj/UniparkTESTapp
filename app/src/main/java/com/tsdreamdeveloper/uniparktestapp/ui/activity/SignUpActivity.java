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

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.tsdreamdeveloper.uniparktestapp.R;
import com.tsdreamdeveloper.uniparktestapp.mvp.presenter.SignUpPresenter;
import com.tsdreamdeveloper.uniparktestapp.mvp.view.SignUpView;

import static com.tsdreamdeveloper.uniparktestapp.common.Utils.phonePrefix;
import static com.tsdreamdeveloper.uniparktestapp.mvp.presenter.SignUpPresenter.MESSAGE;

public class SignUpActivity extends BaseActivity implements SignUpView {

    @InjectPresenter
    SignUpPresenter presenter;

    private EditText mPhone;
    private EditText mFirstname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mPhone = findViewById(R.id.et_phone);
        mFirstname = findViewById(R.id.et_firstname);
        onSignUp();
        onBack();
        phonePrefix(mPhone);
    }

    public void onSignUp() {
        findViewById(R.id.button_sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = mFirstname.getText().toString().trim();
                String phone = mPhone.getText().toString().trim();

                presenter.setFirstname(firstname);
                presenter.setPhone(phone);
                presenter.registration();
            }
        });
    }

    public void onBack() {
        findViewById(R.id.button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            }
        });
    }

    @Override
    public void showMessage(String message) {
        if (message.equals(MESSAGE)) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage(message);
            builder1.setCancelable(true);
            builder1.setNegativeButton(
                    NEGATIVE_BUTTON_TEXT,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            onBack();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        } else {
            super.showMessage(message);
        }
    }
}
