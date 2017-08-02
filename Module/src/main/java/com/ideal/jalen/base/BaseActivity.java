package com.ideal.jalen.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Toast;

import com.ideal.jalen.R;
import com.ideal.jalen.entity.appstatus.AppStatusConstant;
import com.ideal.jalen.entity.appstatus.AppStatusManager;
import com.ideal.jalen.permission.PermissionConstants;
import com.ideal.jalen.permission.PermissionUtils;

import java.util.ArrayList;
import java.util.List;

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

    //    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    private OnPermissionListener onPermissionListener;
    private int permissionId;

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

                toolbar = (Toolbar) findViewById(R.id.toolbar);

                if (toolbar != null) {
                    setSupportActionBar(toolbar);
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                }

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
                if (Build.VERSION.SDK_INT >= 21) {
                    finishAfterTransition();
                } else {
                    finish();
                }
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

    //[+] 权限相关

    //检查一个权限
    public void checkPermission(boolean showRequestPermissionRationale, @IntRange(from = PermissionConstants.PERMISSION_NUM_MIN, to = PermissionConstants.PERMISSION_NUM_MAX) int permissionId) {
        this.permissionId = permissionId;
        String permissionName = PermissionUtils.getPermissionName(permissionId);
        if (checkPermission(permissionName)) {
            if (onPermissionListener != null) {
                onPermissionListener.onHavePermission();
            }
        } else {
            if (showRequestPermissionRationale) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissionName)) {
                    if (onPermissionListener != null) {
                        onPermissionListener.onShowPermissionRationale();
                    }
                } else {
                    requestPermission(permissionId);
                }
            } else {
                requestPermission(permissionId);
            }
        }
    }

    //检查多个权限
    public void checkPermission(List<Integer> permissionIdList) {
        if (permissionIdList == null && permissionIdList.isEmpty()) {
            return;
        }

        for (Integer id : permissionIdList) {
            String permissionName = PermissionUtils.getPermissionName(id);
            if (TextUtils.isEmpty(permissionName)) {
                return;
            }
        }

        List<String> permissionNameList = new ArrayList<>();
        for (Integer id : permissionIdList) {
            String permissionName = PermissionUtils.getPermissionName(id);
            if (!checkPermission(permissionName)) {
                permissionNameList.add(permissionName);
            }
        }

        if (permissionNameList.isEmpty()) {
            if (onPermissionListener != null) {
                onPermissionListener.onHavePermission();
            }
        } else {
            ActivityCompat.requestPermissions(this, permissionNameList.toArray(new String[permissionNameList.size()]), PermissionConstants.MORE_PERMISSION_ID);
        }
    }

    /**
     * 检查是否具有权限
     *
     * @param permissionName 权限的名字  比如：写SD卡的权限  Manifest.permission.WRITE_EXTERNAL_STORAGE
     * @return true 有权限  false没有权限
     */
    public boolean checkPermission(String permissionName) {
        return ContextCompat.checkSelfPermission(this, permissionName) == PackageManager.PERMISSION_GRANTED ? true : false;
    }

    private void requestPermission(@IntRange(from = PermissionConstants.PERMISSION_NUM_MIN, to = PermissionConstants.PERMISSION_NUM_MAX) int permissionId) {
        String permissionName = PermissionUtils.getPermissionName(permissionId);
        ActivityCompat.requestPermissions(this, new String[]{permissionName}, permissionId);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults != null && grantResults.length > 0) {
            switch (requestCode) {
                case PermissionConstants.READ_PHONE_STATE:
                case PermissionConstants.CALL_PHONE:
                case PermissionConstants.ACCESS_COARSE_LOCATION:
                case PermissionConstants.RECORD_AUDIO:
                case PermissionConstants.READ_EXTERNAL_STORAGE:
                case PermissionConstants.CAMERA:
                case PermissionConstants.READ_CONTACTS:
                case PermissionConstants.READ_CALENDAR:
                case PermissionConstants.BODY_SENSORS:
                case PermissionConstants.SEND_SMS:
                case PermissionConstants.MORE_PERMISSION_ID:

                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        if (onPermissionListener != null) {
                            onPermissionListener.onHavePermission();
                        }
                    } else {
                        if (onPermissionListener != null) {
                            onPermissionListener.onRefusePermission();
                            Toast.makeText(this, PermissionUtils.getPermissionTip(permissionId, this), Toast.LENGTH_SHORT).show();
                        }
                    }

                    break;
                default:
                    break;
            }
        }
    }

    public void setOnPermissionListener(OnPermissionListener onPermissionListener) {
        this.onPermissionListener = onPermissionListener;
    }

    public interface OnPermissionListener {
        void onHavePermission();

        void onRefusePermission();

        void onShowPermissionRationale();
    }
    //[-] 权限相关
}
