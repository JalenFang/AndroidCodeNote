package com.ideal.jalen.thread.handlerThread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.Html;
import android.widget.TextView;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

import java.util.Locale;

import butterknife.BindView;

/**
 * author: jalen
 * date: 2017/11/28
 * editor:
 * date:
 * describe: HandlerThread的使用
 */
public class HandlerThreadActivity extends BaseActivity {

    @BindView(R.id.activity_handler_thread_desc)
    TextView desc;

    Handler handler;
    private static final int MSG_UPDATE_INFO = 0x100;
    private boolean isUpdate = true;
    private HandlerThread handlerThread;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_handler_thread;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
        //1.创建HandlerThread对象
        handlerThread = new HandlerThread("jalen");
        //2.启动handlerThread
        handlerThread.start();
        //3.将handler和handlerThread绑定在一起
        handler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                checkForUpdate();
                if (isUpdate) {
                    handler.sendEmptyMessage(MSG_UPDATE_INFO);
                }
            }
        };
    }

    private void checkForUpdate() {
        try {
            Thread.sleep(2000);
            desc.post(new Runnable() {
                @Override
                public void run() {
                    String result = "实时更新中，当前股票行情：<font color='red'>%d</font>";
                    result = String.format(Locale.CHINESE, result, (int) (Math.random() * 5000 + 1000));
                    desc.setText(Html.fromHtml(result));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        isUpdate = true;
        super.onResume();
        handler.sendEmptyMessage(MSG_UPDATE_INFO);
    }

    @Override
    protected void onPause() {
        super.onPause();
        isUpdate = false;
        handler.removeMessages(MSG_UPDATE_INFO);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerThread.quit();
        handler.removeCallbacksAndMessages(null);
    }
}
