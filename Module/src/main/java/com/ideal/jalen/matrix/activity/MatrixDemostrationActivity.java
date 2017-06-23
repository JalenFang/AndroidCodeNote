package com.ideal.jalen.matrix.activity;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

import butterknife.BindView;

/**
 * @author Jalen
 * @date 2017/6/23. 10:55
 * @editor
 * @date
 * @describe Matrix操作演示
 */
public class MatrixDemostrationActivity extends BaseActivity {

    @BindView(R.id.activity_matrix_demostration_iv_pic)
    ImageView ivPic;

    Matrix matrix = new Matrix();

    private int picHeight, picWidth;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_matrix_demostration;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
        //ivPic.setScaleType(ImageView.ScaleType.MATRIX);
        ivPic.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= 16) {
                    ivPic.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

                Drawable drawable = ivPic.getDrawable();
                if (drawable == null) {
                    return;
                }

                picWidth = drawable.getIntrinsicWidth();
                picHeight = drawable.getIntrinsicHeight();
            }
        });
    }

    /**
     * Matrix操作有效的操作步骤
     * 1.如果想让ImageView支持Matrix必须设置ScaleType为MATRIX
     * 2.ImageView必须有足够的位置满足操作 否则可能导致它不可见
     * 3.ImageView必须设置图片为src不能是background
     * 4.除Translate(平移)外，Scale(缩放)、Rotate(旋转)、Skew(扭曲)都可以围绕一个中心点来进行，如果不指定，在默认情况下是围绕(0, 0)来进行相应的变换的。
     * 5.Matrix提供的四种操作，每一种都有pre、set、post三种形式。原因是矩阵乘法不满足乘法交换律，因此左乘还是右乘最终的效果都不一样。
     * 我们可以把Matrix变换想象成一个队列，队列里面包含了若干个变换操作，队列中每个操作按照先后顺序操作变换目标完成变换，
     * pre相当于向队首增加一个操作，post相当于向队尾增加一个操作，set相当于清空当前队列重新设置。
     */

    public void onClickMatrixTranslate(View view) {
        matrix.setTranslate(100, 100);
//        matrix.postTranslate(0, 300);
//        matrix.setTranslate(0, 300);
        ivPic.setImageMatrix(matrix);
    }

    public void onClickMatrixScale(View view) {
        matrix.setScale(0.5f, 0.5f, picWidth / 2, picWidth / 2);
        //matrix.setScale(1f, 2f);
        ivPic.setImageMatrix(matrix);
    }

    public void onClickMatrixRotate(View view) {
        matrix.setRotate(180, picWidth / 2, picHeight / 2);
        ivPic.setImageMatrix(matrix);
    }

    public void onClickMatrixSkew(View view) {
        //matrix.setSkew(1f, 2f);
        matrix.setSkew(1f, 2f, picWidth / 2, picHeight / 2);
        ivPic.setImageMatrix(matrix);
    }
}
