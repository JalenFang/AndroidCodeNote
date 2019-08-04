package com.ideal.jalen.canvas.widget.circlescroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.utils.ScreenUtils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * author: Jalen
 * date: 2019-08-03 10:59
 * describe: 圆弧
 */
public class CSArcView extends View {
    private static final String TAG = CSArcView.class.getSimpleName();
    //83  //57
    Paint paint;
    private RectF rectF;
    /**
     * 圆弧圆的半径
     */
//    private int arcCircleRadius = 100;
    private int arcCircleRadius;

    private int[] colors = new int[]{Color.GREEN, Color.YELLOW, Color.RED};

    private SweepGradient sweepGradient;

    private int startAngle;

    /**
     * 圆弧的宽度
     */
    private int arcWidth;

    private int width;
    private Timer timer;
    private Matrix rotateMatrix;
    private int centerX, centerY;

    public CSArcView(Context context) {
        this(context, null);
    }

    public CSArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        arcCircleRadius = ScreenUtils.dp2px(context, 57);
        arcWidth = ScreenUtils.dp2px(context, 83 - 57);
        width = ScreenUtils.dp2px(context, 83) * 2;

        centerX = width / 2;
        centerY = centerX;

        colors = new int[]{ContextCompat.getColor(context, R.color.blue_20_2B92F9),
                ContextCompat.getColor(context, R.color.blue_50_2B92F9),
                ContextCompat.getColor(context, R.color.blue_FF2B92F9)};

        sweepGradient = new SweepGradient(centerX, centerY, colors, null);
        rotateMatrix = new Matrix();


        initView();

        startAnimation();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(width, width);
    }

    private void initView() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(ContextCompat.getColor(getContext(), R.color.common_style_translate));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(arcWidth);

        //设置渐变色
//        rotateMatrix.setRotate(130, centerX, centerY);
//        sweepGradient.setLocalMatrix(rotateMatrix);
        paint.setShader(sweepGradient);

//        rectF = new RectF(0, 0, 160, 160);
        // TODO: 2019-08-04 不太懂这个？
        rectF = new RectF(arcWidth / 2, arcWidth / 2, width - arcWidth / 2, width - arcWidth / 2);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawRect(rectF, paint);
//        paint.setShader(sweepGradient);
        Log.d(TAG, "onDraw: startAngle " + startAngle);
        rotateMatrix.setRotate(startAngle, centerX, centerY);
        sweepGradient.setLocalMatrix(rotateMatrix);
        paint.setShader(sweepGradient);

        canvas.drawArc(rectF, startAngle, 360, false, paint);

    }


    private void startAnimation() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startAngle += 10;
                if (startAngle > 360) {
                    startAngle = 0;
                }

                postInvalidate();
                Log.d(TAG, "startAngle: " + startAngle);

            }
        }, 0, 20);
    }

}
