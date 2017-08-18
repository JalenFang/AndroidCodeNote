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
 * author: Jalen
 * date: 2017/6/23. 10:55
 * describe: Matrix操作演示
 */
public class MatrixDemostrationActivity extends BaseActivity {

    @BindView(R.id.activity_matrix_demostration_iv_pic)
    ImageView ivPic;
    @BindView(R.id.activity_matrix_demostration_iv_pic_Scale)
    ImageView ivPicScale;
    @BindView(R.id.activity_matrix_demostration_iv_pic_Rotate)
    ImageView ivPicRotate;
    @BindView(R.id.activity_matrix_demostration_iv_pic_skew)
    ImageView ivPicSkew;

    Matrix matrixTranslate;
    Matrix matrixScale;
    Matrix matrixRotate;
    Matrix matrixSkew;

    private int picHeight, picWidth;
    private int width;
    private int height;

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
        matrixTranslate = new Matrix();
        matrixScale = new Matrix();
        matrixRotate = new Matrix();
        matrixSkew = new Matrix();
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

                width = ivPic.getWidth();
                height = ivPic.getHeight();

                picWidth = drawable.getIntrinsicWidth();
                picHeight = drawable.getIntrinsicHeight();

                matrixTranslate.setTranslate(width / 2 - picWidth / 2, height / 2 - picHeight / 2);
                matrixScale.setTranslate(width / 2 - picWidth / 2, height / 2 - picHeight / 2);
                matrixRotate.setTranslate(width / 2 - picWidth / 2, height / 2 - picHeight / 2);
                matrixSkew.setTranslate(width / 2 - picWidth / 2, height / 2 - picHeight / 2);

                ivPic.setImageMatrix(matrixTranslate);
                ivPicScale.setImageMatrix(matrixScale);
                ivPicRotate.setImageMatrix(matrixRotate);
                ivPicSkew.setImageMatrix(matrixSkew);
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
        matrixTranslate.postTranslate(30, 0);
//        matrixTranslate.postTranslate(0, 300);
//        matrixTranslate.setTranslate(0, 300);
        ivPic.setImageMatrix(matrixTranslate);
    }

    //缩放的初始值为1 必须改变这个大小 否则无效
    public void onClickMatrixScale(View view) {
        matrixScale.postScale(1.1f, 1.1f, width / 2, height / 2);
        //matrixTranslate.setScale(1f, 2f);
        ivPicScale.setImageMatrix(matrixScale);
    }

    public void onClickMatrixRotate(View view) {
        matrixRotate.postRotate(60, width / 2, height / 2);
        ivPicRotate.setImageMatrix(matrixRotate);
    }

    public void onClickMatrixSkew(View view) {
        //matrixTranslate.setSkew(1f, 2f);
        matrixTranslate.postSkew(1f, 2f, width / 2, height / 2);
        ivPicSkew.setImageMatrix(matrixTranslate);
    }
}
