package com.ideal.jalen.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ideal.jalen.R;

import java.util.List;

public class DrawableAdapter extends RecyclerView.Adapter<DrawableAdapter.ViewHolder> {

    private Context context;
    private List<Integer> items;

    public static DrawableAdapter created(Context context, List<Integer> items) {
        return new DrawableAdapter(context, items);
    }

    private DrawableAdapter(Context context, List<Integer> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_drawable_card_bule, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bitmapIv.setImageResource(items.get(position));
    }

    @Override
    public int getItemCount() {
        return (this.items != null) ? items.size() : 0;
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {
        ImageView bitmapIv;

        ViewHolder(View itemView) {
            super(itemView);
            bitmapIv = (ImageView) itemView.findViewById(R.id.drawable_card_item_iv);
        }
    }
}
