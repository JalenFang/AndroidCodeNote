package com.ideal.jalen.canvas.activity.bezier;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

/**
 * @author Jalen
 * @date 2017/8/17
 * @editor
 * @date
 * @describe 画板
 */
public class DrawBoardActivity extends BaseActivity {
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_draw_board;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }
}
