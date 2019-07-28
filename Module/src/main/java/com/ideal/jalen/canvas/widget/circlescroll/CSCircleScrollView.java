package com.ideal.jalen.canvas.widget.circlescroll;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

import com.ideal.jalen.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author: Jalen
 * date: 2019-07-27 22:35
 * describe:圆嵌套滑动
 */
public class CSCircleScrollView extends FrameLayout {

    @BindView(R.id.blueCircleView)
    CSCircleView blueCircleView;

    private float startX, startY;

    private int touchSlop;

    public CSCircleScrollView(@NonNull Context context) {
        this(context, null);
    }

    public CSCircleScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ButterKnife.bind(LayoutInflater.from(context).inflate(R.layout.view_circle_scroll_view, this));

        initView();
    }

    private void initView() {
        touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                executeScaleToBig();
                break;
            case MotionEvent.ACTION_MOVE:
                float x = event.getX();
                float y = event.getY();

//                if (Math.abs(x - startX) < touchSlop && Math.abs(y - startY) > touchSlop) {
                if(y > startY){

                }
                    int offsetY = (int) (y - startY);
                    offsetTopAndBottom(offsetY);


//                }
//                int offsetX = (int) (x - startX);

//                int l = getLeft() + offsetX;

//                int t = getTop() + offsetY;

//                int r = getRight() + offsetX;

//                int b = getBottom() + offsetY;
//                layout(getLeft(), t, get, b);
                break;
            case MotionEvent.ACTION_UP:
                executeScaleToNormal();
                break;

        }
        return true;
    }

    private void executeScaleToBig() {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(blueCircleView, "scaleX", 1f, 0.8f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(blueCircleView, "scaleY", 1f, 0.8f);

        set.setDuration(500);
//        set.setInterpolator(new DecelerateInterpolator());
        set.play(scaleX).with(scaleY);
        set.start();
    }

    private void executeScaleToNormal() {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(blueCircleView, "scaleX", 0.8f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(blueCircleView, "scaleY", 0.8f, 1f);

        set.setDuration(500);
//        set.setInterpolator(new DecelerateInterpolator());
        set.play(scaleX).with(scaleY);
        set.start();
    }
}
