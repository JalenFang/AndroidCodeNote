package com.ideal.jalen.material.activity.recyclerview_refresh_autoloadmore.interfaces;

import com.ideal.jalen.material.activity.recyclerview_refresh_autoloadmore.viewholder.RecyclerViewCommonViewHolder;

/**
 * @author Jalen
 * @date 2017/6/14 15:04
 * @editor
 * @date
 * @describe
 */

public interface OnItemClickListeners<T> {
    void onItemClick(RecyclerViewCommonViewHolder viewHolder, T data, int viewType, int position);
}
