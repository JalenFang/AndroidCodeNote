package com.ideal.jalen.material.activity.snackbar;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

/**
 *author: Jalen
 * date: 2017/5/8. 16:26
 * describe:
 */
public class SnackbarActivity extends BaseActivity {

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_snackbar;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    public void onClickSnackbar(View v) {
        Snackbar.make(this.findViewById(android.R.id.content), "我是要显示的文字", Snackbar.LENGTH_SHORT)
                .setActionTextColor(ContextCompat.getColor(SnackbarActivity.this, R.color.common_style_red))
                .setAction("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SnackbarActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
}
