package com.ideal.jalen.permission;

/**
 * author: Dragon
 * date: 2016/8/18. 9:15
 * describe: 区别权限
 */
public class PermissionConstants {
    /**
     * 读取设备信息
     */
    public static final int READ_PHONE_STATE = 0;

    /**
     * 打电话
     */
    public static final int CALL_PHONE = 1;

    /**
     * 定位
     */
    public static final int ACCESS_COARSE_LOCATION = 2;

    /**
     * 录音
     */
    public static final int RECORD_AUDIO = 3;

    /**
     * SD卡
     */
    public static final int READ_EXTERNAL_STORAGE = 4;

    /**
     * 拍照
     */
    public static final int CAMERA = 5;

    /**
     * 联系人
     */
    public static final int READ_CONTACTS = 6;

    /**
     * 日历数据
     */
    public static final int READ_CALENDAR = 7;

    /**
     * 传感器
     */
    public static final int BODY_SENSORS = 8;

    /**
     * 短信
     */
    public static final int SEND_SMS = 9;

    /**
     * 请求多个权限的id编号
     */
    public static final int MORE_PERMISSION_ID = 10;

    /**
     * 权限编号的最小值
     */
    public static final int PERMISSION_NUM_MIN = 0;

    /**
     * 权限编号的最大值
     */
    public static final int PERMISSION_NUM_MAX = 9;

}
