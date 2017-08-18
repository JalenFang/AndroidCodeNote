package com.ideal.jalen.progress.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.Html;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

import butterknife.BindView;

/**
 *author: Jalen
 * date: 2017/7/29 17:46
 * describe: 水平进度条
 */
public class ProgressBarHorizontalActivity extends BaseActivity {
    @BindView(R.id.activity_progress_bar_horizontal_tvDesc)
    TextView tvDesc;

    @BindView(R.id.activity_progress_bar_horizontal_progressBar)
    ProgressBar progressBar;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_progress_bar_horizontal;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
        setProgressText(0);
        showProgressBar();
    }

    int per;

    private void showProgressBar() {
        per = 0;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progressBar.setProgress(per * 10);
                handler.postDelayed(this, 100);
                per++;
                if (progressBar.getProgress() == 100) {
                    handler.removeCallbacks(this);
                }

                if (progressBar.getProgress() <= 100) {
                    setProgressText(progressBar.getProgress());
                }
            }
        };
        handler.post(runnable);
    }

    private void setProgressText(int progress) {
        String format = String.format("当前进度 ：<font color=\"#41A0FF\">%d", progress);
        if (Build.VERSION.SDK_INT < 24) {
            tvDesc.setText(Html.fromHtml(format));
        } else {
            tvDesc.setText(Html.fromHtml(format, Html.FROM_HTML_MODE_LEGACY));
        }
    }
}
