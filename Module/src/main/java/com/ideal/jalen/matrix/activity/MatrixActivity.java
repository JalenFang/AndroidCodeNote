package com.ideal.jalen.matrix.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

/**
 * @author Jalen
 * @date 2017/6/22. 17:55
 * @editor
 * @date
 * @describe 矩阵的使用介绍
 */
public class MatrixActivity extends BaseActivity {
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_matrix;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }
}
