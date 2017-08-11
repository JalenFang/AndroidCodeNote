package com.ideal.jalen.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.utils.ScreenUtils;

/**
 * @author Jalen
 * @date 2016/12/23 21:52
 * @describe 弧线
 */
public class ArcView extends View {
    private Paint paint;

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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawArcView(canvas);
        drawRect(canvas);

        drawRect2(canvas);
        drawArcView2(canvas);

        drawRect3(canvas);
        drawArcView3(canvas);

        drawRect4(canvas);
        drawArcView4(canvas);
    }

    //当 drawArcs(rect,startAngel,sweepAngel,useCenter,paint)中的
    // useCenter为false时，弧线区域是用弧线开始角度和结束角度直接连接起来的，
    // 当useCenter为true时，是弧线开始角度和结束角度都与中心点连接，形成一个扇形。
    //startAngel 从X轴的正方向开始顺时针开始递增
    //Arc是矩形的内切圆

    private void drawArcView2(Canvas canvas) {
        RectF rect = new RectF(200, 200, 400, 400);
        canvas.drawArc(rect, //弧线所使用的矩形区域大小
                0,  //开始角度
                90, //扫过的角度
                true, //是否使用中心
                paint);
    }

    private void drawRect2(Canvas canvas) {
        RectF rect = new RectF(200, 200, 400, 400);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, paint);
    }

    private void drawRect(Canvas canvas) {
        RectF rect = new RectF(0, 0, 100, 100);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, paint);
    }

    private void drawRect4(Canvas canvas) {
        RectF rect = new RectF(300, 0, 400, 100);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, paint);
    }

    private void drawArcView4(Canvas canvas) {
        RectF rect = new RectF(300, 0, 400, 100);
        canvas.drawArc(rect, //弧线所使用的矩形区域大小
                270,  //开始角度
                90, //扫过的角度
                false, //是否使用中心
                paint);
    }

    private void drawArcView(Canvas canvas) {
        RectF rect = new RectF(0, 0, 100, 100);
        canvas.drawArc(rect, //弧线所使用的矩形区域大小
                0,  //开始角度
                90, //扫过的角度
                false, //是否使用中心
                paint);
    }

    private void drawArcView3(Canvas canvas) {
        RectF rect = new RectF(400, 400, 600, 600);
        canvas.drawArc(rect, //弧线所使用的矩形区域大小
                45,  //开始角度
                90, //扫过的角度
                true, //是否使用中心
                paint);
    }

    private void drawRect3(Canvas canvas) {
        RectF rect = new RectF(400, 400, 600, 600);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, paint);
    }


}
