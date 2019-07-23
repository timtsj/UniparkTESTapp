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

package com.tsdreamdeveloper.uniparktestapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tsdreamdeveloper.uniparktestapp.R;
import com.tsdreamdeveloper.uniparktestapp.mvp.model.Datum;

import java.util.List;

/**
 * @author Timur Seisembayev
 * @since 22.07.2019
 */
public class TransportAdapter extends RecyclerView.Adapter<TransportAdapter.ViewHolder> {

    /**
     * The interface that receives onClick item.
     */
    public interface OnItemClickListener {
        void onItemClick(Datum datum);
    }

    private LayoutInflater inflater;
    private List<Datum> datumList;
    private final OnItemClickListener listener;

    public TransportAdapter(Context context, List<Datum> datumList, OnItemClickListener onItemClickListener) {
        this.datumList = datumList;
        this.inflater = LayoutInflater.from(context);
        listener = onItemClickListener;
    }

    @Override
    public TransportAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_dummy_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TransportAdapter.ViewHolder holder, int position) {
        Datum datum = datumList.get(position);
        String name = datum.getName() + " " + datum.getTransportNumber();
        holder.mNameTV.setText(name);
        holder.bind(datum, listener);
    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mNameTV;

        ViewHolder(View view) {
            super(view);
            mNameTV = view.findViewById(R.id.tv_name);
        }

        void bind(final Datum item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    public void setItems(List<Datum> datumList) {
        this.datumList.addAll(datumList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        this.datumList.clear();
        notifyDataSetChanged();
    }
}