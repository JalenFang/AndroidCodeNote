package com.ideal.jalen.canvas.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

/**
 * @author Jalen
 * @date 2016/12/14
 * @describe 贝塞尔曲线
 */
public class BezierActivity extends BaseActivity {
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_bezier;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }
}
