package com.ideal.jalen.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ideal.jalen.R;
import com.ideal.jalen.base.MainActivity;
import com.ideal.jalen.entity.appstatus.AppStatusConstant;
import com.ideal.jalen.entity.appstatus.AppStatusManager;

/**
 * @author Jalen
 * @date 2017/6/22. 16:19
 * @editor
 * @date
 * @describe 闪屏页面
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppStatusManager.getInstance().setAppStatus(AppStatusConstant.STATUS_NORMAL);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 100);
    }
}
