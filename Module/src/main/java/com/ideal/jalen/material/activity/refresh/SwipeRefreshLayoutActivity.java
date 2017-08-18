package com.ideal.jalen.material.activity.refresh;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;
import com.ideal.jalen.recyclerview.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author: Jalen
 * date: 2017/5/18. 14:30
 * describe:
 */
public class SwipeRefreshLayoutActivity extends BaseActivity {

    @BindView(R.id.activity_swipe_refresh_layout_swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.activity_swipe_refresh_layout_recyclerView)
    RecyclerView recyclerView;

    private Handler handler = new Handler();
    List<String> dataList = new ArrayList<>();
    private RecyclerViewAdapter recyclerViewAdapter;

    private static final int DELAYED_TIME = 2000;

    private int count = 0;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_swipe_refresh_layout;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
//        swipeRefreshLayout.setColorSchemeResources(R.color.common_style_blue);
        swipeRefreshLayout.setColorSchemeResources(R.color.common_style_blue, R.color.common_style_red, R.color.common_style_orange);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);//刷新图标显示
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setDataList();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(this, dataList);
        recyclerView.setAdapter(recyclerViewAdapter);

        setDataList();
    }

    private void setDataList() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<String> dataList = new ArrayList<>();
                int j = 0;
                for (int i = count; i < count + 20; i++) {
                    dataList.add("" + i);
                    j = i;
                }
                count += j;
                recyclerViewAdapter.setData(dataList);
                swipeRefreshLayout.setRefreshing(false);//刷新图标关闭
            }
        }, DELAYED_TIME);
    }
}
