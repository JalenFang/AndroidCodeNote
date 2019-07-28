package com.ideal.jalen.canvas.widget.circlescroll;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.utils.ScreenUtils;

/**
 * author: Jalen
 * date: 2019-07-27 22:28
 * describe:
 */
public class CSCircleView extends View {
    private Paint paint;
    private int circleColor;
    private int circleRadius;

    public CSCircleView(Context context) {
        this(context, null);
    }

    public CSCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray attr = context.obtainStyledAttributes(attrs, R.styleable.CSCircleView);
        circleColor = attr.getColor(R.styleable.CSCircleView_circleColor, ContextCompat.getColor(context, R.color.blue_FF2B92F9));
        int radius = attr.getInt(R.styleable.CSCircleView_circleRadius, 5);
        circleRadius = ScreenUtils.dp2px(getContext(), radius);
        attr.recycle();

        initView();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(circleRadius * 2, circleRadius * 2);
    }

    private void initView() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(circleColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(ScreenUtils.dp2px(getContext(), 3));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(circleRadius, circleRadius, circleRadius, paint);
    }
}

