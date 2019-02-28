package com.ideal.jalen.canvas.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.util.Log;
import android.widget.ImageView;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

import java.io.File;
import java.io.FileOutputStream;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Author: Jalen
 * Email: braveJalen@163.com
 * Date: 2018/10/8 15:18
 * Version:
 * Desc: 图片合成
 */
public class CanvasPicSynthesisActivity extends BaseActivity {
    /**
     * 传递进来的源图片
     */
    private Bitmap source;
    /**
     * 图片的配文
     */
    private String text;
    /**
     * 图片加上配文后生成的新图片
     */
    private Bitmap newBitmap;
    /**
     * 配文的颜色
     */
    private int textColor = Color.BLACK;
    /**
     * 配文的字体大小
     */
    private float textSize = 16;
    /**
     * 图片的宽度
     */
    private int bitmapWidth;
    /**
     * 图片的高度
     */
    private int bitmapHeight;
    /**
     * 画图片的画笔
     */
    private Paint bitmapPaint;
    /**
     * 画文字的画笔
     */
    private Paint textPaint;
    /**
     * 配文与图片间的距离
     */
    private float padding = 20;
    /**
     * 配文行与行之间的距离
     */
    private float linePadding = 5;

    @BindView(R.id.activity_pic_synthesis_imgPic)
    ImageView imgPic;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_pic_synthesis;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    @OnClick(R.id.activity_pic_synthesis_btnStartSynthesis)
    protected void btnStartSynthesis() {
        String path = startSynthesis();
        imgPic.setImageBitmap(BitmapFactory.decodeFile(path));
    }

    private String startSynthesis() {
        textPaint = new TextPaint();
        textPaint.setTextSize(textSize);// 字体大小
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);// 采用默认的宽度
        textPaint.setColor(Color.WHITE);// 采用的颜色
        textPaint.setAntiAlias(true);

        text = "窗前明月光，疑是地上霜，举头望明月，低头思故乡 \n  窗前明月光，疑是地上霜，举头望明月，低头思故乡 \n 窗前明月光，疑是地上霜，举头望明月，低头思故乡";

        Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.banner);

        source = ((BitmapDrawable) drawable).getBitmap();

        bitmapWidth = source.getWidth();
        bitmapHeight = source.getHeight();

        //一行可以显示文字的个数
        int lineTextCount = (int) ((source.getWidth() - 50) / textSize);

        //一共要把文字分为几行
        int line = (int) Math.ceil(Double.valueOf(text.length()) / Double.valueOf(lineTextCount));

        //新创建一个新图片比源图片多出一部分，后续用来与文字叠加用
        newBitmap = Bitmap.createBitmap(bitmapWidth,
                (int) (bitmapHeight + padding + textSize * line + linePadding * line), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(newBitmap);

        bitmapPaint = new Paint();
        //把图片画上来
        canvas.drawBitmap(source, 0, 0, bitmapPaint);

        //在图片下边画一个白色矩形块用来放文字，防止文字是透明背景，在有些情况下保存到本地后看不出来
        textPaint.setColor(Color.WHITE);
        canvas.drawRect(0, source.getHeight(), source.getWidth(),
                source.getHeight() + padding + textSize * line + linePadding * line, textPaint);

        //把文字画上来
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);

        Rect bounds = new Rect();

        //开启循环直到画完所有行的文字
        for (int i = 0; i < line; i++) {

            String s;
            if (i == line - 1) {//如果是最后一行，则结束位置就是文字的长度，别下标越界哦
                s = text.substring(i * lineTextCount, text.length());
            } else {//不是最后一行
                s = text.substring(i * lineTextCount, (i + 1) * lineTextCount);
            }

            //获取文字的字宽高以便把文字与图片中心对齐
            textPaint.getTextBounds(s, 0, s.length(), bounds);

            //画文字的时候高度需要注意文字大小以及文字行间距
            canvas.drawText(s, source.getWidth() / 2 - bounds.width() / 2,
                    source.getHeight() + padding + i * textSize + i * linePadding + bounds.height() / 2, textPaint);
        }

        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.restore();

        String path = getExternalCacheDir() + File.separator + +System.currentTimeMillis() + ".jpg";
        Log.e("jalen", "path: " + path);

        FileOutputStream b;
        try {
            b = new FileOutputStream(path);
            newBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
            b.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        newBitmap.recycle();

        return path;
    }


    //[+] 签到图片添加水印
   /* private String addWaterLine(String imgLocalPath) {
        if (TextUtils.isEmpty(imgLocalPath)) {
            return null;
        }

//        int bitmapDegree = getBitmapDegree(imgLocalPath);

        String waterLinePicPath = null;

        String compressedImgPath = NativeUtil.compressSync(imgLocalPath);//压缩图片
        if (TextUtils.isEmpty(compressedImgPath)) {
            return null;
        }

        Bitmap zoomBitmap = BitmapFactory.decodeFile(compressedImgPath);

       *//* Matrix matrix = new Matrix();
        matrix.postRotate(bitmapDegree);
        zoomBitmap = Bitmap.createBitmap(zoomBitmap, 0, 0, zoomBitmap.getWidth(), zoomBitmap.getHeight(), matrix, true);*//*

        int screenWidth, sp2px, textSize = 0, dip2px;
        float space = 0f;
        if (getActivity() != null) {
            screenWidth = ScreenUtils.screenWidth(getActivity());
            sp2px = ScreenUtils.sp2px(getActivity(), 15);
            textSize = zoomBitmap.getWidth() * sp2px / screenWidth;
            dip2px = ScreenUtils.dp2px(getActivity(), 20);
            space = zoomBitmap.getWidth() * dip2px / screenWidth;
        }

        if (zoomBitmap != null) {
            Bitmap newBmp = Bitmap.createBitmap(zoomBitmap.getWidth(), zoomBitmap.getHeight(), Bitmap.Config.ARGB_8888);

            //画底图
            Canvas canvas = new Canvas(newBmp);
            Paint photoPaint = new Paint();
            photoPaint.setDither(true);
            photoPaint.setFilterBitmap(true);
            canvas.drawBitmap(zoomBitmap, 0, 0, photoPaint);

            float x = 20.0f;
            float y = zoomBitmap.getHeight();
            if (signInView.aMapLocation != null && signInView.aMapLocation.getAddress() != null) {

                TextPaint textPaint = new TextPaint();
                textPaint.setTextSize(textSize);// 字体大小
                textPaint.setTypeface(Typeface.DEFAULT_BOLD);// 采用默认的宽度
                textPaint.setColor(Color.WHITE);// 采用的颜色
                textPaint.setAntiAlias(true);

                if (getActivity() != null) {
                    textPaint.setShadowLayer(3f, 1, 1, ContextCompat.getColor(getActivity(), android.R.color.background_dark));// 阴影的设置
                }

                // 写地址
                StaticLayout addressLayout = new StaticLayout(signInView.aMapLocation.getAddress(), textPaint, zoomBitmap.getWidth() - 20, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
                int height = addressLayout.getHeight();
                canvas.save();
                canvas.translate(x, y - height);
                addressLayout.draw(canvas);
                canvas.restore();

                // 写姓名
                String userName = "";//防止没有公司昵称
                if (!TextUtils.isEmpty(UserConfig.getInstance().getCompanyUserConfig().UserName)) {
                    userName = UserConfig.getInstance().getCompanyUserConfig().UserName;
                } else {
                    if (!TextUtils.isEmpty(UserConfig.getInstance().getUserName())) {
                        userName = UserConfig.getInstance().getUserName();
                    }
                }

                StaticLayout userNameLayout = new StaticLayout(userName, textPaint, zoomBitmap.getWidth() - 20, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
                canvas.save();
                canvas.translate(x, y - height - space);
                userNameLayout.draw(canvas);
                canvas.restore();

                // 写时间
                String str = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
                String[] time = str.split(" ");

                StaticLayout dataLayout = new StaticLayout(time[0], textPaint, zoomBitmap.getWidth() - 20, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
                canvas.save();
                canvas.translate(x, y - height - 2 * space);
                dataLayout.draw(canvas);

                StaticLayout timeLayout = new StaticLayout(time[1], textPaint, zoomBitmap.getWidth() - 20, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
                canvas.save();
                canvas.translate(x, y - height - 3 * space);
                timeLayout.draw(canvas);
                canvas.restore();
            }

            canvas.save(Canvas.ALL_SAVE_FLAG);
            canvas.restore();

            waterLinePicPath = UserConfig.getInstance().getUserPath().getUserImgPath() + System.currentTimeMillis() + ".jpg";
            FileOutputStream b;
            try {
                b = new FileOutputStream(waterLinePicPath);
                newBmp.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
                b.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            zoomBitmap.recycle();
            newBmp.recycle();
        }
        return waterLinePicPath;
    }

    //获取原始图片的角度
    private int getBitmapDegree(String path) {
        int degree = 0;
        try {
            // 从指定路径下读取图片，并获取其EXIF信息
            ExifInterface exifInterface = new ExifInterface(path);
            // 获取图片的旋转信息
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }*/
//[-] 签到图片添加水印

}