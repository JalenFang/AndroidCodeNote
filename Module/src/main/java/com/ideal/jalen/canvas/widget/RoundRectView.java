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
 * date: 2016/12/8 21:03
 * describe: 圆角矩形
 */
public class RoundRectView extends View {

    private Paint paint;
    private Paint rectPaint;

    public RoundRectView(Context context) {
        super(context);
        init();
    }

    public RoundRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
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
            rectPaint.setStyle(Paint.Style.FILL);
            rectPaint.setStrokeWidth(ScreenUtils.dp2px(getContext(), 3));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawRoundRectView(canvas);
    }

    private void drawRoundRectView(Canvas canvas) {
        RectF rectF = new RectF(100, 100, 200, 200);
        canvas.drawRect(rectF, rectPaint);
        // TODO: 2017/8/11  rx  ry 目前的作用不清楚
        canvas.drawRoundRect(rectF, 30, 60, paint);
    }
}
