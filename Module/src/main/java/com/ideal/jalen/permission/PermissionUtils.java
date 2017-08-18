package com.ideal.jalen.permission;

import android.Manifest;
import android.content.Context;
import android.support.annotation.IntRange;

import com.ideal.jalen.R;


/**
 * author: Jalen
 * date: 2016/8/18. 9:32
 * describe: 根据权限的ID获得权限的名字
 */
public class PermissionUtils {

    public static String getPermissionName(@IntRange(from = PermissionConstants.PERMISSION_NUM_MIN, to = PermissionConstants.PERMISSION_NUM_MAX) int permissionId) {
        String permissionName = null;
        switch (permissionId) {
            case PermissionConstants.READ_PHONE_STATE:
                permissionName = Manifest.permission.READ_PHONE_STATE;
                break;
            case PermissionConstants.CALL_PHONE:
                permissionName = Manifest.permission.CALL_PHONE;
                break;
            case PermissionConstants.ACCESS_COARSE_LOCATION:
                permissionName = Manifest.permission.ACCESS_COARSE_LOCATION;
                break;
            case PermissionConstants.RECORD_AUDIO:
                permissionName = Manifest.permission.RECORD_AUDIO;
                break;
            case PermissionConstants.READ_EXTERNAL_STORAGE:
                permissionName = Manifest.permission.READ_EXTERNAL_STORAGE;
                break;
            case PermissionConstants.CAMERA:
                permissionName = Manifest.permission.CAMERA;
                break;
            case PermissionConstants.READ_CONTACTS:
                permissionName = Manifest.permission.READ_CONTACTS;
                break;
            case PermissionConstants.READ_CALENDAR:
                permissionName = Manifest.permission.READ_CALENDAR;
                break;
            case PermissionConstants.BODY_SENSORS:
                permissionName = Manifest.permission.BODY_SENSORS;
                break;
            case PermissionConstants.SEND_SMS:
                permissionName = Manifest.permission.SEND_SMS;
                break;
            default:
                break;
        }
        return permissionName;
    }

    public static String getPermissionTip(@IntRange(from = PermissionConstants.PERMISSION_NUM_MIN, to = PermissionConstants.PERMISSION_NUM_MAX) int permissionId, Context context) {
        String permissionTip = "";
        switch (permissionId) {
            case PermissionConstants.READ_PHONE_STATE:
                permissionTip = context.getString(R.string.permission_read_phone_state_refuse);
                break;
            case PermissionConstants.CALL_PHONE:
                permissionTip = context.getString(R.string.permission_call_phone_refuse);
                break;
            case PermissionConstants.ACCESS_COARSE_LOCATION:
                permissionTip = context.getString(R.string.permission_location_refuse);
                break;
            case PermissionConstants.RECORD_AUDIO:
                permissionTip = context.getString(R.string.permission_record_refuse);
                break;
            case PermissionConstants.READ_EXTERNAL_STORAGE:
                permissionTip = context.getString(R.string.permission_sd_refuse);
                break;
            case PermissionConstants.CAMERA:
                permissionTip = context.getString(R.string.permission_camera_refuse);
                break;
            case PermissionConstants.READ_CONTACTS:
                permissionTip = context.getString(R.string.permission_read_contacts_refuse);
                break;
            case PermissionConstants.READ_CALENDAR:
                permissionTip = context.getString(R.string.permission_read_calendar_refuse);
                break;
            case PermissionConstants.BODY_SENSORS:
                permissionTip = context.getString(R.string.permission_body_sensors_refuse);
                break;
            case PermissionConstants.SEND_SMS:
                permissionTip = context.getString(R.string.permission_send_sms_refuse);
                break;
            default:
                break;
        }
        return permissionTip;
    }

}
