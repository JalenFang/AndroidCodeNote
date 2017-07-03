package com.ideal.jalen.animator.activity.transition;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;
import com.ideal.jalen.utils.ScreenUtils;

import butterknife.BindView;

/**
 * @author Jalen
 * @date 2017/6/19. 15:35
 * @editor
 * @date
 * @describe
 */
public class TransitionDelayActivity extends BaseActivity {

    @BindView(R.id.activity_transition_delay_ll_container)
    LinearLayout llRootView;

    @BindView(R.id.activity_transition_delay_view_circul_one)
    View viewCirculOne;

    @BindView(R.id.activity_transition_delay_view_circul_two)
    View viewCirculTwo;

    @BindView(R.id.activity_transition_delay_tv_desc)
    TextView tvDesc;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_transition_delay;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
        countDownTimer.start();
    }

    @Override
    public void collection() {
        super.collection();
        countDownTimer.cancel();
    }

    private CountDownTimer countDownTimer = new CountDownTimer(4 * 1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            tvDesc.setText(String.format("%d秒钟后开始执行延时动画", millisUntilFinished / 1000));
        }

        @Override
        public void onFinish() {
            tvDesc.setText("开始执行延时动画");
            executeDelayedTransition();
        }
    };

    private void executeDelayedTransition() {
        if (Build.VERSION.SDK_INT >= 19) {
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.setDuration(1000);
            TransitionManager.beginDelayedTransition(llRootView, changeBounds);

            int sizeOne = ScreenUtils.dp2px(getActivity(), 150);
            int sizeTwo = ScreenUtils.dp2px(getActivity(), 50);

            ViewGroup.LayoutParams layoutParams = viewCirculOne.getLayoutParams();
            layoutParams.height = sizeOne;
            layoutParams.width = sizeOne;
            viewCirculOne.setLayoutParams(layoutParams);

            ViewGroup.LayoutParams layoutParams2 = viewCirculTwo.getLayoutParams();
            layoutParams2.height = sizeTwo;
            layoutParams2.width = sizeTwo;
            viewCirculTwo.setLayoutParams(layoutParams2);
        }
    }
}
