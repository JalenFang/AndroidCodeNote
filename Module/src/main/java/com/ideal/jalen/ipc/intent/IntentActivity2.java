package com.ideal.jalen.ipc.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

import butterknife.BindView;

/**
 * author: jalen
 * date: 2017/11/24
 * editor:
 * date:
 * describe:进程间通信方式 intent
 */
public class IntentActivity2 extends BaseActivity {
    public static final String TEXT = "text";

    @BindView(R.id.activity_intent2_text)
    TextView tv;


    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_intent2;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(TEXT);
            tv.setText(stringExtra);
        }
    }
}
