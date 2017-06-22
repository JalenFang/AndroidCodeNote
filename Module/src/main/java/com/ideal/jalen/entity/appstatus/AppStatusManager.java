package com.ideal.jalen.entity.appstatus;

/**
 * @author Jalen
 * @date 2017/5/27. 10:34
 * @editor
 * @date
 * @describe 获取App当前的状态
 */
public class AppStatusManager {
    //首次启动应用必须设置为 AppStatusConstant.STATUS_NORMAL
    public int appStatus = AppStatusConstant.STATUS_FORCE_KILLED;

    public static AppStatusManager appStatusManager;

    private AppStatusManager() {

    }

    public static AppStatusManager getInstance() {
        if (appStatusManager == null) {
            appStatusManager = new AppStatusManager();
        }
        return appStatusManager;
    }

    public int getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(int appStatus) {
        this.appStatus = appStatus;
    }
}
