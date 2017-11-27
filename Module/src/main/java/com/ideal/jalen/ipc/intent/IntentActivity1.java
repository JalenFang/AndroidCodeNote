package com.ideal.jalen.ipc.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

import butterknife.OnClick;

/**
 * author: jalen
 * date: 2017/11/24
 * editor:
 * date:
 * describe: 进程间通信方式 intent
 */
public class IntentActivity1 extends BaseActivity {
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_intent1;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    @OnClick(R.id.activity_intent1_btn)
    public void clickButton() {
        Intent intent = new Intent(getActivity(), IntentActivity2.class);
        intent.putExtra(IntentActivity2.TEXT, "哈哈哈哈");
        startActivity(intent);
    }
}
