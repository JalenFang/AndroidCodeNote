package com.ideal.jalen.material.activity.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;
import com.ideal.jalen.recyclerview.adapter.DrawableAdapter;
import com.ideal.jalen.utils.IconsHelperUtil;

import butterknife.BindView;

/**
 * author: Jalen
 * date: 2017/5/24. 17:20
 * describe:
 */
public class LinearHorizontalActivity extends BaseActivity {

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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(DrawableAdapter.created(this, IconsHelperUtil.BEE_ICONS));
    }

}
