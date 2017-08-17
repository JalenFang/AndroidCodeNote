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
 * @date 2016/12/14
 * @describe 贝塞尔曲线
 */
public class TwoOrderBezierView extends View {

    private Paint paint;
    private PointF startPoint;
    private PointF endPoint;
    private PointF assistPoint;// 辅助点
    private Path path;
    private Paint pointPaint;

    public TwoOrderBezierView(Context context) {
        this(context, null);
    }

    public TwoOrderBezierView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        initPaint();
        initPoint();
        path = new Path();
    }

    private void initPoint() {
        startPoint = new PointF(400, 500);
        endPoint = new PointF(600, 500);
        assistPoint = new PointF(100, 200);
    }

    private void initPaint() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(ContextCompat.getColor(getContext(), R.color.common_style_blue));
        paint.setStrokeWidth(ScreenUtils.dp2px(getContext(), 5));
        paint.setStyle(Paint.Style.STROKE);
        paint.setDither(true);

        pointPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pointPaint.setStrokeWidth(ScreenUtils.dp2px(getContext(), 5));
        pointPaint.setStyle(Paint.Style.FILL);
        pointPaint.setColor(ContextCompat.getColor(getContext(), R.color.common_style_red));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 重置路径
        path.reset();
        // 起点
        path.moveTo(startPoint.x, startPoint.y);
        //public void quadTo(float x1, float y1, float x2, float y2)
        //参数中(x1,y1)是控制点坐标，(x2,y2)是终点坐标
        path.quadTo(assistPoint.x, assistPoint.y, endPoint.x, endPoint.y);
        // 画路径
        canvas.drawPath(path, paint);
        // 画辅助点
        canvas.drawPoint(assistPoint.x, assistPoint.y, pointPaint);
        //画起点
        canvas.drawPoint(startPoint.x, startPoint.y, pointPaint);
        //画终点
        canvas.drawPoint(endPoint.x, endPoint.y, pointPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                assistPoint.x = event.getX();
                assistPoint.y = event.getY();
                invalidate();
                break;
            default:
                break;
        }
        return true;
    }
}
