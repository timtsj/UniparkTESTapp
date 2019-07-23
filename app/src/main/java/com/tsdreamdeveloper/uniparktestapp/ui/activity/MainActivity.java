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

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.tsdreamdeveloper.uniparktestapp.R;
import com.tsdreamdeveloper.uniparktestapp.mvp.model.Datum;
import com.tsdreamdeveloper.uniparktestapp.mvp.presenter.MainPresenter;
import com.tsdreamdeveloper.uniparktestapp.mvp.view.MainView;
import com.tsdreamdeveloper.uniparktestapp.ui.adapter.TransportAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Timur Seisembayev
 * @since 20.07.2019
 */

public class MainActivity extends BaseActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    private List<Datum> datumList = new ArrayList<>();
    private TransportAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.getTransports();
        initRecyclerView();
    }

    /**
     * Implement RecyclerView and CityAdapter
     */
    private void initRecyclerView() {
        RecyclerView mTransportsRV = findViewById(R.id.rv_transports);
        mTransportsRV.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TransportAdapter(this, datumList, new TransportAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Datum datum) {

            }
        });
        mTransportsRV.setAdapter(adapter);
    }

    @Override
    public void addList(List<Datum> datumList) {
        this.datumList.addAll(datumList);
        adapter.setItems(this.datumList);
    }
}
