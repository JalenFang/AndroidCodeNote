package com.ideal.jalen.animator.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.animator.activity.transition.customcolorchange.TransitionCustomColorActivity;
import com.ideal.jalen.animator.activity.transition.pagecontent.PageContentFirstActivity;
import com.ideal.jalen.animator.activity.transition.shareelement.ShareElementFirstActivity;
import com.ideal.jalen.animator.activity.transition.TransitionAddTargetActivity;
import com.ideal.jalen.animator.activity.transition.TransitionBaseUseActivity;
import com.ideal.jalen.animator.activity.transition.TransitionDelayActivity;
import com.ideal.jalen.base.BaseActivity;

/**
 * author: Jalen
 * date: 2017/6/23. 14:48
 * describe: 动画的主界面
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

    public void onClickTransitionCustomColor(View view) {
        startActivity(TransitionCustomColorActivity.class);
    }

    public void onClickTransitionPageContent(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            startActivity(new Intent(this, PageContentFirstActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            startActivity(PageContentFirstActivity.class);
        }
    }

    public void onClickTransitionShareElement(View view) {
        startActivity(ShareElementFirstActivity.class);
    }

    private void startActivity(Class<?> activity) {
        startActivity(new Intent(AnimatorActivity.this, activity));
    }
}
