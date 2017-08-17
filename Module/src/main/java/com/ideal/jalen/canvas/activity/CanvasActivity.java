package com.ideal.jalen.canvas.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;
import com.ideal.jalen.canvas.activity.bezier.BezierActivity;

/**
 * @author Jalen
 * @date 2016/12/6 21:46
 * @editor
 * @date
 * @describe
 */
public class CanvasActivity extends BaseActivity {
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_canvas;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    public void onClickBezier(View view) {
        startActivity(BezierActivity.class);
    }

    public void onClickBaseOperation(View view) {
        startActivity(CanvasBaseOperationActivity.class);
    }

    private void startActivity(Class<?> className) {
        startActivity(new Intent(getActivity(), className));
    }
}
