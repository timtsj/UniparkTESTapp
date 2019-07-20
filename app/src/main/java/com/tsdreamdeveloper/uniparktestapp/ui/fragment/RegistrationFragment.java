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


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.tsdreamdeveloper.uniparktestapp.R;
import com.tsdreamdeveloper.uniparktestapp.mvp.presenter.RegistrationPresenter;
import com.tsdreamdeveloper.uniparktestapp.mvp.view.RegistrationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.tsdreamdeveloper.uniparktestapp.common.Utils.phonePrefix;
import static com.tsdreamdeveloper.uniparktestapp.mvp.presenter.RegistrationPresenter.MESSAGE;

/**
 * @author Timur Seisembayev
 * @since 20.07.2019
 */
public class RegistrationFragment extends BaseFragment implements RegistrationView {

    @InjectPresenter
    RegistrationPresenter presenter;

    @BindView(R.id.et_phone)
    EditText mPhone;

    @BindView(R.id.et_firstname)
    EditText mFirstname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        phonePrefix(mPhone);
    }

    @OnClick({R.id.button_sign_up})
    public void onSignUp() {
        String firstname = mFirstname.getText().toString().trim();
        String phone = mPhone.getText().toString().trim();

        presenter.setFirstname(firstname);
        presenter.setPhone(phone);
        presenter.registration();
    }

    @OnClick(R.id.button_back)
    public void onBack() {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new LoginFragment())
                .commit();
    }

    @Override
    public void showMessage(String message) {
        if (message.equals(MESSAGE)) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
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
