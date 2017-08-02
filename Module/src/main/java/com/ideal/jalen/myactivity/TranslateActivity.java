package com.ideal.jalen.myactivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

/**
 * @author Jalen
 * @date 2017/8/1
 * @editor
 * @date
 * @describe 透明activity
 */
public class TranslateActivity extends BaseActivity {

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_translate;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }
}
