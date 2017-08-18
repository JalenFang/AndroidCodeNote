package com.ideal.jalen.animator.activity.transition;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

import butterknife.BindView;

/**
 * author: Jalen
 * date: 2017/6/16. 14:51
 * describe: 过渡动画的基本使用
 */
public class TransitionBaseUseActivity extends BaseActivity {

    @BindView(R.id.activity_transition_base_use_fl_rootview)
    FrameLayout flRootView;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_transition_base_use;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    public void onClickTransitionBaseUseStartAnimator(View v) {
        if (Build.VERSION.SDK_INT >= 19) {
            Scene scene2 = Scene.getSceneForLayout(flRootView, R.layout.scene2, v.getContext());
            TransitionManager.go(scene2, new ChangeBounds());
        }
    }

    public void onClickTransitionBaseUsePauseAnimator(View view) {
        Toast.makeText(TransitionBaseUseActivity.this, "无Api", Toast.LENGTH_SHORT).show();
    }

    public void onClickTransitionBaseUseCancelAnimator(View view) {
        Toast.makeText(TransitionBaseUseActivity.this, "无Api", Toast.LENGTH_SHORT).show();
    }
}
