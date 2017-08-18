package com.ideal.jalen.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.utils.ScreenUtils;

/**
 * @author Jalen
 * @date 2017/8/18
 * @editor
 * @date
 * @describe 画板（使用两阶贝塞尔曲线）
 */
public class DrawBoardView extends View {

    private Paint paint;
    private Path path;
    private PointF startPoint;
    private PointF endPoint;
    private PointF assistPoint;

    public DrawBoardView(Context context) {
        this(context, null);
    }

    public DrawBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        initPaint();
        initPath();
        initPoint();
    }

    private void initPaint() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(ContextCompat.getColor(getContext(), R.color.common_style_blue));
        paint.setStrokeWidth(ScreenUtils.dp2px(getContext(), 3));
        paint.setStyle(Paint.Style.STROKE);
    }

    private void initPath() {
        path = new Path();
    }

    private void initPoint() {
        startPoint = new PointF();
        endPoint = new PointF();
        assistPoint = new PointF();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startPoint.x = event.getX();
                startPoint.y = event.getY();
                path.moveTo(startPoint.x, startPoint.y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                endPoint.x = event.getX();
                endPoint.y = event.getY();

                //控制点 是 起点和终点的中间
                assistPoint.x = (startPoint.x + endPoint.x) / 2;
                assistPoint.y = (startPoint.y + endPoint.y) / 2;

                path.quadTo(assistPoint.x, assistPoint.y, endPoint.x, endPoint.y);

                startPoint = endPoint;

                invalidate();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }

    public void reset() {
        if (path != null) {
            path.reset();
            invalidate();
        }
    }

    public void changeColor(int colorId) {
        if (paint == null) {
            initPaint();
        }
        paint.setColor(ContextCompat.getColor(getContext(), colorId));
    }
}
