package com.ideal.jalen.viewpager.adapter;


import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Dragon
 * @date 2016/11/11 14:07
 * @editor
 * @date
 * @describe 通用的viewpager适配器
 */
public class CommonViewPagerAdapter<v extends View> extends PagerAdapter {
    public v[] views;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CommonViewPagerAdapter(v[] views) {
        super();
        this.views = views;
    }

    public  v[] getViews(){
        return views;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views[position];
        if (view != null) {
            container.addView(view);
        }
        return view;
    }

    @Override
    public int getCount() {
        return views.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = views[position];
        if (view != null) {
            container.removeView(view);
        }
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}