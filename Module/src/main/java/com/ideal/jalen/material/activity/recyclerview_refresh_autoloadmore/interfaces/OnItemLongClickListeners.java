package com.ideal.jalen.material.activity.recyclerview_refresh_autoloadmore.interfaces;

import com.ideal.jalen.material.activity.recyclerview_refresh_autoloadmore.viewholder.RecyclerViewCommonViewHolder;

/**
 * @author Jalen
 * @date 2017/6/14 15:04
 * @editor
 * @date
 * @describe
 */

public interface OnItemLongClickListeners<T> {
    void onItemLongClick(RecyclerViewCommonViewHolder viewHolder, T data, int viewType, int position);
}
