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
 * @date 2016/12/15 22:01
 * @describe  椭圆
 */
public class OvalView extends View {
    private Paint paint;

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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawOval(canvas);
        drawRect(canvas);
    }

    private void drawRect(Canvas canvas) {
        RectF rect = new RectF(100, 200, 300, 400);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLUE);
        canvas.drawRect(rect, paint);
    }

    private void drawOval(Canvas canvas) {
        RectF rect = new RectF(100, 200, 300, 400);
        canvas.drawOval(rect, paint);
        //canvas.drawOval(100f, 100f, 200f, 200f, paint);
    }
}
