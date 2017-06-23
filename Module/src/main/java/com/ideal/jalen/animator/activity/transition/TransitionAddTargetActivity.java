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
 * @author Jalen
 * @date 2017/6/19. 15:16
 * @editor
 * @date
 * @describe 指定动画执行者
 */
public class TransitionAddTargetActivity extends BaseActivity {

    @BindView(R.id.activity_transition_add_target_fl_rootview)
    FrameLayout flRootView;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_transition_add_target;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    public void onClickTransitionAddTargetStartAnimator(View v) {
        if (Build.VERSION.SDK_INT >= 19) {
            Scene scene2 = Scene.getSceneForLayout(flRootView, R.layout.scene2, v.getContext());
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.addTarget(R.id.image1);//指定动画的执行者  只让image1执行
            TransitionManager.go(scene2, changeBounds);
        }
    }

    public void onClickTransitionAddTargetPauseAnimator(View view) {
        Toast.makeText(TransitionAddTargetActivity.this, "无Api", Toast.LENGTH_SHORT).show();
    }

    public void onClickTransitionAddTargetCancelAnimator(View view) {
        Toast.makeText(TransitionAddTargetActivity.this, "无Api", Toast.LENGTH_SHORT).show();
    }
}
