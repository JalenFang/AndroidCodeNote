package com.ideal.jalen.material.activity.drawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;
import com.ideal.jalen.recyclerview.adapter.RecyclerViewAdapter;

import butterknife.BindView;


/**
 * author: Jalen
 * date: 2017/5/12. 17:39
 * describe: 设置从哪个方向划出 需要给view设置 layout_gravity属性  可以参考XML文件
 */
public class DrawerLayoutSimpleActivity extends BaseActivity {

    @BindView(R.id.activity_drawer_layout_recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.activity_drawer_layout_drawerLayout)
    DrawerLayout drawerLayout;

    @BindView(R.id.ll_menu_left)
    LinearLayout menuLeft;

    @BindView(R.id.ll_menu_right)
    LinearLayout menuRight;

    //  mDrawer.setScrimColor(getResources().getColor(R.color.color_2095f2));
    //  mDrawer.openDrawer(Gravity.RIGHT);

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_drawer_layout;
    }


    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        initRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_drawer_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.drawer_layout_menu_red:
                //设置滑动出来的背景色
                drawerLayout.setScrimColor(ContextCompat.getColor(getApplicationContext(), R.color.common_style_red));
                break;
            case R.id.drawer_layout_menu_blue:
                drawerLayout.setScrimColor(ContextCompat.getColor(getApplicationContext(), R.color.common_style_blue));
                break;
            case R.id.drawer_layout_menu_right://从右侧主动划出
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            case R.id.drawer_layout_menu_left://从左侧主动划出
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
    }

}
