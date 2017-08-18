package com.ideal.jalen.material.activity.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;
import com.ideal.jalen.recyclerview.adapter.DrawableAdapter;
import com.ideal.jalen.utils.IconsHelperUtil;

import butterknife.BindView;

/**
 * author: Jalen
 * date: 2017/5/24. 18:23
 * describe:
 */
public class GridActivity extends BaseActivity {

    @BindView(R.id.activity_recyclerView)
    RecyclerView recyclerView;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_recycler_view;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(DrawableAdapter.created(this, IconsHelperUtil.BEE_ICONS));
    }
}
