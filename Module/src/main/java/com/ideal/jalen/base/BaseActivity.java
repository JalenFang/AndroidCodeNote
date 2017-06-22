package com.ideal.jalen.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ideal.jalen.R;
import com.ideal.jalen.entity.appstatus.AppStatusConstant;
import com.ideal.jalen.entity.appstatus.AppStatusManager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Jalen
 * @date 2017/6/22. 11:48
 * @editor
 * @date
 * @describe Activity的基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    public abstract Activity getActivity();

    public abstract int getLayout();

    public abstract void initUI(@Nullable Bundle savedInstanceState);

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (AppStatusManager.getInstance().getAppStatus()) {
            case AppStatusConstant.STATUS_FORCE_KILLED:
                restartApp();
                break;
            case AppStatusConstant.STATUS_NORMAL:
                setContentView(getLayout());
                ButterKnife.bind(getActivity());

                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);


                initUI(savedInstanceState);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        collection();
    }

    public void collection() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        if (toolbar != null) {
            toolbar.setTitle(title);
        }
    }

    protected void restartApp() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(AppStatusConstant.KEY_HOME_ACTION, AppStatusConstant.ACTION_RESTART_APP);
        startActivity(intent);
    }
}
