package com.ideal.jalen.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * author: jalen
 * date: 2017/11/24
 * editor:
 * date:
 * describe: dialog的工具类
 */
public class DialogUtil {

    private DialogUtil() {
    }

    private static DialogUtil util;

    public static DialogUtil getInstance() {
        if (util == null) {
            synchronized (DialogUtil.class) {
                util = new DialogUtil();
            }
        }
        return util;
    }

    public void showDialog(Activity context, String title, String[] textArray, final ReturnClickPosition listener) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setItems(textArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (listener != null) {
                            listener.clickPosition(which);
                        }
                    }
                })
                .show();
    }

    public interface ReturnClickPosition {
        void clickPosition(int position);
    }
}
