package com.ideal.jalen.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.utils.ScreenUtils;

/**
 * @author Jalen
 * @date 2016/12/14 21:04
 * @describe 线
 */
public class LineView extends View {

    private Paint paint;

    public LineView(Context context) {
        super(context);
        init();
    }

    public LineView(Context context, AttributeSet attrs) {
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
        drawLine(canvas);
        drawLine1(canvas);
        drawLine2(canvas);
    }

    private void drawLine(Canvas canvas) {
        canvas.drawLine(0, 0, 100, 100, paint);
    }

    private void drawLine1(Canvas canvas) {
        canvas.drawLine(100, 100, 200, 0, paint);
    }

    private void drawLine2(Canvas canvas) {
        canvas.drawLine(0, 0, 200, 0, paint);
    }

}
