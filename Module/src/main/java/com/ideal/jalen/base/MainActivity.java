package com.ideal.jalen.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.animator.activity.AnimatorActivity;
import com.ideal.jalen.attrsstyle.activity.AttrsStyleActivity;
import com.ideal.jalen.canvas.activity.CanvasActivity;
import com.ideal.jalen.entity.appstatus.AppStatusConstant;
import com.ideal.jalen.material.activity.MaterialActivity;
import com.ideal.jalen.matrix.activity.MatrixActivity;
import com.ideal.jalen.myactivity.MyActivity;
import com.ideal.jalen.progress.activity.ProgressBarActivity;
import com.ideal.jalen.splash.SplashActivity;
import com.ideal.jalen.test.Test1Acitivity;
import com.ideal.jalen.view.activity.ViewActivity;

/**
 * author: Jalen
 * date: 2017/6/22. 16:18
 * describe: 主页面
 */
public class MainActivity extends BaseActivity {
    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int action = intent.getIntExtra(AppStatusConstant.KEY_HOME_ACTION, AppStatusConstant.ACTION_BACK_TO_HOME);
        switch (action) {
            case AppStatusConstant.ACTION_RESTART_APP:
                restartApp();
                break;
            default:
                break;
        }
    }

    @Override
    protected void restartApp() {
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }

    public void onClickMatrixMain(View view) {
        startActivity(MatrixActivity.class);
    }

    public void onClickAnimatorMain(View view) {
        startActivity(AnimatorActivity.class);
    }

    public void onClickMaterial(View view) {
        startActivity(MaterialActivity.class);
    }

    public void onClickCanvas(View view) {
        startActivity(CanvasActivity.class);
    }

    public void onClickAttrsStyle(View view) {
        startActivity(AttrsStyleActivity.class);
    }

    public void onClickProgressBar(View view) {
        startActivity(ProgressBarActivity.class);
    }

    public void onClickActivity(View view) {
        startActivity(MyActivity.class);
    }

    public void onClickView(View view) {
        startActivity(ViewActivity.class);
    }

    public void onClickTest(View view) {
        startActivity(Test1Acitivity.class);
    }

    private void startActivity(Class<?> className) {
        startActivity(new Intent(getActivity(), className));
    }
}
