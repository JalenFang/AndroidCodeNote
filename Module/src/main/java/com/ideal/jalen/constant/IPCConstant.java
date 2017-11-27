package com.ideal.jalen.constant;

/**
 * author: jalen
 * date: 2017/11/24
 * editor:
 * date:
 * describe:进程间通行的类型
 */
public class IPCConstant {
    /**
     * 使用 Intent
     */
    public static final int INTENT = 0;
    /**
     * 使用 Messenger
     */
    public static final int MESSENGER = 1;
    /**
     * 使用 AIDL
     */
    public static final int AIDL = 2;
    /**
     * 使用 ContentProvider
     */
    public static final int CONTENT_PROVIDER = 3;
    /**
     * 使用 Socket
     */
    public static final int SOCKET = 4;
}
