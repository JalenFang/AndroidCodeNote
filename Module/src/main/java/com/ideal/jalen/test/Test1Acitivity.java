package com.ideal.jalen.test;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

import butterknife.BindView;

/**
 * @author Dragon
 * @date 2017/7/21
 * @editor
 * @date
 * @describe
 */
public class Test1Acitivity extends BaseActivity {

    @BindView(R.id.activity_test_1_progressBar)
    ProgressBar progressBar;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_test_1;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
        initProgresBar();
        handler.post(runnable);
    }

    private void initProgresBar() {
        progressBar.setProgress(10);
    }

    //300ms 100
//    30ms      10
    int i = 0;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            progressBar.setProgress(i * 10);
            i++;
            handler.postDelayed(this, 30);
        }
    };


    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }

    class MyDialog extends Dialog {
        public MyDialog(Context context) {
            super(context);
            init();
        }

        private void init() {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.dialong_test, null);
            setContentView(view);

            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    dismiss();
                    return true;
                }
            });
        }
    }


}
