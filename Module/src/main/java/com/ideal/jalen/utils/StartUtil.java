package com.ideal.jalen.utils;

import android.content.Context;
import android.content.Intent;

/**
 *author: Jalen
 * date: 2017/8/17
 * @editor
 * date:
 * describe: 跳转工具类
 */
public class StartUtil {

    public static void startActivity(Context context, Class<?> className) {
        context.startActivity(new Intent(context, className));
    }

}
