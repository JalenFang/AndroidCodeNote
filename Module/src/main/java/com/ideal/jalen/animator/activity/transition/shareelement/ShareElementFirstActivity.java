package com.ideal.jalen.animator.activity.transition.shareelement;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;


/**
 * @author Jalen
 * @date 2017/6/20. 14:21
 * @editor
 * @date
 * @describe 共享元素
 */
public class ShareElementFirstActivity extends BaseActivity {
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_share_element_first;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    public void onClickShareElementFirstView(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            startActivity(new Intent(ShareElementFirstActivity.this, ShareElementSecondActivity.class), ActivityOptions.makeSceneTransitionAnimation(this, view, "share").toBundle());
        } else {
            startActivity(new Intent(ShareElementFirstActivity.this, ShareElementSecondActivity.class));
        }
    }

}
