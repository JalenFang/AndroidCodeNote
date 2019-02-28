package com.ideal.jalen.bitmap.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

import butterknife.BindView;

/**
 * Author: Jalen
 * Email: braveJalen@163.com
 * Date: 2018/12/22 16:00
 * Desc:bitmap压缩处理
 */
public class BitmapActivity extends BaseActivity {

    @BindView(R.id.activity_bitmap_imgBitmap)
    protected ImageView imgBitmap;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_bitmap;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.wutong_mountain);
        int byteCount = bitmap.getByteCount();
        double v = byteCount * 1.0 / 1024 / 1024;
        Log.i("jalen", "bitmap 占用内存大小：" + v + "M");

        double v1 = byteCount * 1.0 / 4032 / 3016;
        Log.i("jalen", "v1：" + v1);

        imgBitmap.setImageBitmap(bitmap);
    }
}
