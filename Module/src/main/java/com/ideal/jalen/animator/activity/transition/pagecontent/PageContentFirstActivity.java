package com.ideal.jalen.animator.activity.transition.pagecontent;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;
import com.ideal.jalen.constant.AnimatorConstant;


/**
 * @author Jalen
 * @date 2017/6/20. 9:28
 * @editor
 * @date
 * @describe 页面内容过渡动画
 */
public class PageContentFirstActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTransiton();
        super.onCreate(savedInstanceState);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_page_content_first;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }


    //进入页面二
    public void onClickTransitionEnterSecondPage(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            startActivity(new Intent(this, PageContentSecondActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            startActivity(new Intent(this, PageContentSecondActivity.class));
        }
    }

    private void setTransiton() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

            getWindow().setAllowEnterTransitionOverlap(false);
            getWindow().setAllowReturnTransitionOverlap(false);

            //幻灯片

            //进入当前界面动画
            Slide slide = new Slide(Gravity.TOP);
            slide.setDuration(AnimatorConstant.DURATION_TIME);
            getWindow().setEnterTransition(slide);

            //从当前界面返回动画(退出当前界面)
            Slide slide1 = new Slide();
            slide1.setDuration(AnimatorConstant.DURATION_TIME);
            slide1.setSlideEdge(Gravity.TOP);
            getWindow().setReturnTransition(slide1);

            //从当前界面进入到别的界面的动画
            Slide slideExit = new Slide(Gravity.BOTTOM);
            slideExit.setDuration(AnimatorConstant.DURATION_TIME);
            getWindow().setExitTransition(slideExit);

            //从别的界面回到当前界面的动画
            Slide slideReenter = new Slide(Gravity.BOTTOM);
            slideReenter.setDuration(AnimatorConstant.DURATION_TIME);
            getWindow().setReenterTransition(slideReenter);


            //淡入淡出
           /* Fade fadeEnter = new Fade();
            fadeEnter.setMode(Fade.IN);
            fadeEnter.setDuration(AnimatorConstant.DURATION_TIME);
            getWindow().setEnterTransition(fadeEnter);

            Fade fadeReturn = new Fade();
            fadeReturn.setMode(Fade.OUT);
            fadeReturn.setDuration(AnimatorConstant.DURATION_TIME);
            getWindow().setReturnTransition(fadeReturn);

            Fade fadeExit = new Fade(Fade.OUT);
            fadeExit.setDuration(AnimatorConstant.DURATION_TIME);
            getWindow().setExitTransition(fadeExit);

            Fade fadeReenter = new Fade();
            fadeReenter.setMode(Fade.IN);
            fadeReenter.setDuration(AnimatorConstant.DURATION_TIME);
            getWindow().setReenterTransition(fadeReenter);*/
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
