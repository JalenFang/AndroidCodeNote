package com.ideal.jalen.material.activity.tab;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;
import com.ideal.jalen.fragment.FragmentFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author: Jalen
 * date: 2017/5/12. 10:56
 * describe:
 */
public class TabLayoutTopActivity extends BaseActivity {
    @BindView(R.id.activity_tab_layout_top_viewPager)
    ViewPager viewPager;

    @BindView(R.id.activity_tab_layout_top_tabLayout)
    TabLayout tabLayout;

    private static final int TAB_COUNT = 3;
    private List<String> contentList;
    private List<Fragment> fragmentList;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_tab_layout_top;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
        initViewPager();
        initTabLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tab_layout_top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tab_layout_top_menu_MODE_FIXED:
                tabLayout.setTabMode(TabLayout.MODE_FIXED);
                break;
            case R.id.tab_layout_top_menu_MODE_SCROLLABLE:
                tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
                break;
            case R.id.tab_layout_top_menu_add:
                contentList.add("Tab " + contentList.size());
                fragmentList.add(FragmentFactory.newInstant(contentList.get(contentList.size() - 1)));
                viewPagerAdapter.notifyDataSetChanged();
                tabLayout.setupWithViewPager(viewPager);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initViewPager() {
        contentList = new ArrayList<>();
        for (int i = 0; i < TAB_COUNT; i++) {
            contentList.add("tab" + i);
        }

        fragmentList = new ArrayList<>();
        for (int i = 0; i < TAB_COUNT; i++) {
            fragmentList.add(FragmentFactory.newInstant(contentList.get(i)));
        }

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void initTabLayout() {
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        ViewCompat.setElevation(tabLayout, 90);
        tabLayout.setupWithViewPager(viewPager);//这个很重要 tab的数量和viewpager的数量一样了

        for (int i = 0; i < TAB_COUNT; i++) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i);
            if (tabAt != null) {
                tabAt.setText(contentList.get(i));
            }
        }
        TabLayout.Tab tabAt = tabLayout.getTabAt(0);
        if (null != tabAt) {
            tabAt.select();
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return contentList.get(position);
        }
    }
}
