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
 * @date 2017/8/17
 * @editor
 * @date
 * @describe 二阶贝塞尔曲线
 */
public class TwoOrderBezierActivity extends BaseActivity {
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_two_order_bezier;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    public void onClickBaseOperation(View view) {
        StartUtil.startActivity(getActivity(), TwoOrderBezierBaseOperationActivity.class);
    }

    public void onClickDrawingBoard(View view) {
        StartUtil.startActivity(getActivity(),DrawBoardActivity.class);
    }
}
