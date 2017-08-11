package com.ideal.jalen.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.utils.ScreenUtils;

/**
 * @author Jalen
 * @date 2016/12/6 21:46
 * @describe 矩形
 */
public class RectView extends View {
    private Paint paint;

    public RectView(Context context) {
        super(context);
        init();
    }

    public RectView(Context context, AttributeSet attrs) {
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
        drawRect1(canvas);
        drawRect2(canvas);
    }

    private void drawRect1(Canvas canvas) {
        Rect rect = new Rect(50, 50, 200, 200);
        canvas.drawRect(rect, paint);
    }

    private void drawRect2(Canvas canvas) {
        Rect rect = new Rect(200, 200, 500, 500);
        canvas.drawRect(rect, paint);
    }
}
