package com.ideal.jalen.animator.activity.transition.customcolorchange;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

import butterknife.BindView;


/**
 * @author Jalen
 * @date 2017/6/19. 17:05
 * @editor
 * @date
 * @describe 自定义颜色改变的过渡动画
 */
public class TransitionCustomColorActivity extends BaseActivity {

    @BindView(R.id.activity_transition_custom_color_ll_rootView)
    LinearLayout llRootView;

    @BindView(R.id.activity_transition_custom_color_view)
    View view;

    @BindView(R.id.activity_transition_custom_color_tv_desc)
    TextView tvDesc;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_transition_custom_color;
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
            TransitionManager.beginDelayedTransition(llRootView, new CustomColorTransition());
            view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.common_style_orange));
        }
    }
}
