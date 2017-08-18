package com.ideal.jalen.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

import butterknife.OnLongClick;

/**
 *author: Dragon
 * date: 2017/7/21
 * @editor
 * date:
 * describe:
 */
public class Test2Acitivity extends BaseActivity {
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_test_2;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    @OnLongClick(R.id.activity_test_2_tv_test)
    public boolean click() {
        finish();
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.w("dragon", "Test2Acitivity dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.w("dragon", "Test2Acitivity dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.w("dragon", "Test2Acitivity dispatchTouchEvent ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.w("dragon", "Test2Acitivity dispatchTouchEvent ACTION_CANCEL");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

}
