package com.ideal.jalen.myactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

/**
 * author: Jalen
 * date: 2017/8/1
 * describe:
 */
public class MyActivity extends BaseActivity {

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_my_activity;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    public void onClickTranslateActivity(View view) {
        startActivity(TranslateActivity.class);
    }

    private void startActivity(Class<?> className) {
        startActivity(new Intent(getActivity(), className));
    }
}
