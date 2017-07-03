package com.ideal.jalen.material.activity.drawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

import butterknife.BindView;

/**
 * @author Jalen
 * @date 2017/5/17. 15:13
 * @editor
 * @date
 * @describe
 */
public class DrawerLayoutAnimationActivity extends BaseActivity {

    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @BindView(R.id.activity_drawer_layout_animation)
    DrawerLayout drawerLayout;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_drawer_layout_animation;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(mActionBarDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }
}
