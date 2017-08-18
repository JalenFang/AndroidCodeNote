package com.ideal.jalen.canvas.activity.bezier;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;
import com.ideal.jalen.utils.StartUtil;

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

    public void onClickTwoOrderBezier(View view) {
        StartUtil.startActivity(getActivity(), TwoOrderBezierActivity.class);
    }

    public void onClickThreeOrderBezier(View view) {

    }

}
