package com.ideal.jalen.canvas.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

/**
 * @author Jalen
 * @date 2016/12/6
 * @editor
 * @date
 * @describe canvas的基本操作
 */
public class CanvasBaseOperationActivity extends BaseActivity {
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_canvas_base_operation;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }
}
