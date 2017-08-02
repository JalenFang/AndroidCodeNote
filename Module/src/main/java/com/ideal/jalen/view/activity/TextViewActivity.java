package com.ideal.jalen.view.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

import butterknife.BindView;

/**
 * @author Jalen
 * @date 2017/8/1
 * @editor
 * @date
 * @describe TextView
 */
public class TextViewActivity extends BaseActivity {

    @BindView(R.id.activity_text_view_first)
    TextView tvFirst;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_text_view;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
        showFirst();
    }

    private void showFirst() {
        if (Build.VERSION.SDK_INT >= 24) {
//            tvFirst.setText();
        }
    }
}
