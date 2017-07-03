package com.ideal.jalen.material.activity.textinput;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Toast;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;

/**
 * @author Dragon
 * @date 2017/6/7. 15:04
 * @editor
 * @date
 * @describe 颜色设置参考 http://blog.csdn.net/android_freshman/article/details/51136657
 */
public class TextInputLayoutActivity extends BaseActivity {

    @BindView(R.id.activity_text_input_layout_textInputLayout)
    TextInputLayout textInputLayout;

    @BindView(R.id.activity_text_input_layout_textInputEditText)
    TextInputEditText textInputEditText;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_text_input_layout;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    public void onClickLogin(View v) {
        if (verifyMobile()) {
            textInputLayout.setErrorEnabled(false);
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        } else {
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError("手机号格式错误");
        }

    }

    public boolean verifyMobile() {
        Pattern pattern = Pattern.compile("1\\d{10}");
        Matcher matcher = pattern.matcher(textInputEditText.getText().toString());
        return matcher.matches();
    }
}
