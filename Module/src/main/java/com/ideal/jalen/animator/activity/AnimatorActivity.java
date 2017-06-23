package com.ideal.jalen.animator.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.animator.activity.transition.TransitionAddTargetActivity;
import com.ideal.jalen.animator.activity.transition.TransitionBaseUseActivity;
import com.ideal.jalen.animator.activity.transition.TransitionDelayActivity;
import com.ideal.jalen.base.BaseActivity;

/**
 * @author Jalen
 * @date 2017/6/23. 14:48
 * @editor
 * @date
 * @describe 动画的主界面
 */
public class AnimatorActivity extends BaseActivity {
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_animator;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    public void onClickTransitionBaseUse(View view) {
        startActivity(TransitionBaseUseActivity.class);
    }

    public void onClickTransitionAddTarget(View view) {
        startActivity(TransitionAddTargetActivity.class);
    }

    public void onClickTransitionDelay(View view) {
        startActivity(TransitionDelayActivity.class);
    }

    private void startActivity(Class<?> activity) {
        startActivity(new Intent(AnimatorActivity.this, activity));
    }
}
