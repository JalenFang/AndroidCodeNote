package com.ideal.jalen.progress.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

/**
 * @author Jalen
 * @date 2017/7/29 17:33
 * @describe
 */
public class ProgressBarActivity extends BaseActivity {
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_progress_bar;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    public void onClickProgressBarHorizontal(View view) {
        startActivity(ProgressBarHorizontalActivity.class);
    }

    private void startActivity(Class<?> className) {
        startActivity(new Intent(getActivity(), className));
    }
}
