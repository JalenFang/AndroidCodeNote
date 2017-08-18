package com.ideal.jalen.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.ideal.jalen.utils.ScreenUtils;

/**
 * author: Dragon
 * date: 2017/4/13. 10:22
 * describe: 绘制点
 */
public class PointView extends View {

    private Paint paint;

    public PointView(Context context) {
        super(context);
        init();
    }

    public PointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(ScreenUtils.dp2px(getContext(), 5));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPoint(canvas);
    }

    private void drawPoint(Canvas canvas) {
        canvas.drawPoint(0, 0, paint);
        canvas.drawPoint(0, 20, paint);
        canvas.drawPoint(20, 20, paint);

        int width = getWidth();
        int height = getHeight();

        canvas.drawPoint(width / 2, height / 2, paint);
    }
}
