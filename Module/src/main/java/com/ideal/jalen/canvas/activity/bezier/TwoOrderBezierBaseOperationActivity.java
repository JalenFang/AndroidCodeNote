package com.ideal.jalen.canvas.activity.bezier;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

/**
 * author: Jalen
 * date: 2017/8/17
 * describe: 二阶贝塞尔曲线的基本使用
 */
public class TwoOrderBezierBaseOperationActivity extends BaseActivity {

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_two_order_bezier_base_operation;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }
}
