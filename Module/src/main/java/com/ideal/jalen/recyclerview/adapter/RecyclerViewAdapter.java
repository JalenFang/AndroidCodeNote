package com.ideal.jalen.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ideal.jalen.R;

import java.util.List;
import java.util.Locale;

public class RecyclerViewAdapter extends Adapter<ViewHolder> {

    private Context context;
    private List<String> data;

    public RecyclerViewAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data == null ? 20 : data.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_base, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        if (data == null) {
            itemViewHolder.tv.setText(String.format(Locale.CHINESE, "Current Position %d", position));
        } else {
            itemViewHolder.tv.setText(data.get(position));
        }
    }


    private static class ItemViewHolder extends ViewHolder {
        TextView tv;

        ItemViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.item_base_tv);
        }
    }

}