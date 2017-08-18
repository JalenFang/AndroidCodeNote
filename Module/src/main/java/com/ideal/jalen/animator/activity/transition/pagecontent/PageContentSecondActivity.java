package com.ideal.jalen.animator.activity.transition.pagecontent;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Window;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;
import com.ideal.jalen.constant.AnimatorConstant;


/**
 * author: Dragon
 * date: 2017/6/20. 9:40
 * describe: 页面内容过渡动画
 */
public class PageContentSecondActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTransition();
        super.onCreate(savedInstanceState);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_page_content_second;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    private void setTransition() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

            getWindow().setAllowEnterTransitionOverlap(false);
            getWindow().setAllowReturnTransitionOverlap(false);

            Slide slide = new Slide(Gravity.TOP);
            slide.setDuration(AnimatorConstant.DURATION_TIME);
            getWindow().setEnterTransition(slide);

            Slide slide1 = new Slide();
            slide1.setDuration(AnimatorConstant.DURATION_TIME);
            slide1.setSlideEdge(Gravity.END);
            getWindow().setReturnTransition(slide1);


            /*Slide slideExit = new Slide(Gravity.LEFT);
            slideExit.setDuration(AnimatorConstant.DURATION_TIME);
            getWindow().setExitTransition(slideExit);


            Slide slideReenter = new Slide(Gravity.RIGHT);
            slideReenter.setDuration(AnimatorConstant.DURATION_TIME);
            getWindow().setReenterTransition(slideReenter);*/

            //淡入淡出
            /*Fade fadeEnter = new Fade();
            fadeEnter.setMode(Fade.IN);
            fadeEnter.setDuration(AnimatorConstant.DURATION_TIME);
            getWindow().setEnterTransition(fadeEnter);

            Fade fadeReturn = new Fade();
            fadeReturn.setMode(Fade.OUT);
            fadeReturn.setDuration(AnimatorConstant.DURATION_TIME);
            getWindow().setReturnTransition(fadeReturn);*/
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT >= 21) {
            finishAfterTransition();
        } else {
            finish();
        }
    }
}
