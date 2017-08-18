package com.ideal.jalen.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.utils.ScreenUtils;

/**
 * author: Jalen
 * date: 2016/12/23 21:52
 * describe: 弧线
 */
public class ArcView extends View {
    private Paint paint;
    private Paint rectPaint;

    public ArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ArcView(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (paint == null) {
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setColor(ContextCompat.getColor(getContext(), R.color.common_style_red));
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(ScreenUtils.dp2px(getContext(), 3));
        }

        if (rectPaint == null) {
            rectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            rectPaint.setColor(ContextCompat.getColor(getContext(), R.color.common_style_blue));
            rectPaint.setStyle(Paint.Style.STROKE);
            rectPaint.setStrokeWidth(ScreenUtils.dp2px(getContext(), 3));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawArcView(canvas);
        drawArcView2(canvas);
    }

    //当 drawArcs(rect,startAngel,sweepAngel,useCenter,paint)中的
    // useCenter为false时，弧线区域是用弧线开始角度和结束角度直接连接起来的，
    // 当useCenter为true时，是弧线开始角度和结束角度都与中心点连接，形成一个扇形。
    //startAngel 从X轴的正方向 为0   顺时针开始递增  原点在矩形的中心

    private void drawArcView(Canvas canvas) {
        RectF rect = new RectF(0, 0, 100, 100);
        canvas.drawRect(rect, rectPaint);
        canvas.drawArc(rect, //弧线所使用的矩形区域大小
                0,  //开始角度
                270, //扫过的角度
                false, //是否使用中心
                paint);
    }

    private void drawArcView2(Canvas canvas) {
        RectF rect = new RectF(200, 200, 400, 400);
        canvas.drawRect(rect, rectPaint);
        canvas.drawArc(rect, //弧线所使用的矩形区域大小
                0,  //开始角度
                270, //扫过的角度
                true, //是否使用中心
                paint);
    }


}
