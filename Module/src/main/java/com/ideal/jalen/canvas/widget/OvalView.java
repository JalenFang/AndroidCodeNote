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
 * date: 2016/12/15 22:01
 * describe: 椭圆
 */
public class OvalView extends View {
    private Paint paint;
    private Paint rectPaint;

    public OvalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OvalView(Context context) {
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
        drawOval(canvas);
        drawOval1(canvas);
    }

    //椭圆是矩形的内切圆
    private void drawOval1(Canvas canvas) {
        RectF rectF = new RectF(150, 50, 300, 100);
        canvas.drawRect(rectF, rectPaint);
        canvas.drawOval(rectF, paint);
    }

    private void drawOval(Canvas canvas) {
        RectF rect = new RectF(0, 0, 100, 100);
        canvas.drawRect(rect, rectPaint);
        canvas.drawOval(rect, paint);
    }
}
