package com.ideal.jalen.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.utils.ScreenUtils;

/**
 * author: Jalen
 * date: 2016/12/15 21:32
 * describe: 圆
 */
public class CircleView extends View {
    private Paint paint;

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, AttributeSet attrs) {
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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCircleView(canvas);
        drawCircleView1(canvas);
    }

    private void drawCircleView1(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(150, 200, 100, paint);
    }

    private void drawCircleView(Canvas canvas) {
        canvas.drawCircle(150, 200, 50, paint);
    }
}
