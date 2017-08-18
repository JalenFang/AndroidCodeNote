package com.ideal.jalen.material.activity.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;
import com.ideal.jalen.recyclerview.adapter.DrawableAdapter;
import com.ideal.jalen.utils.IconsHelperUtil;

import butterknife.BindView;

/**
 * author: Jalen
 * date: 2017/5/24. 17:54
 * describe:
 */
public class StaggeredActivity extends BaseActivity {

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
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(DrawableAdapter.created(StaggeredActivity.this, IconsHelperUtil.BEE_ICONS));
    }
}
