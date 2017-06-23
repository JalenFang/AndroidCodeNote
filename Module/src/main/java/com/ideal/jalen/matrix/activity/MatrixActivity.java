package com.ideal.jalen.matrix.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

/**
 * @author Jalen
 * @date 2017/6/22. 17:55
 * @editor
 * @date
 * @describe 矩阵的使用介绍
 */
public class MatrixActivity extends BaseActivity {

    Matrix matrix = new Matrix();
    float[] valueArray = new float[9];

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_matrix;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
        // matrix.setValues();
        matrix.getValues(valueArray);

        Log.i("dragon", "MSCALE_X = " + valueArray[Matrix.MSCALE_X] + "\n");
        Log.i("dragon", "MSCALE_Y = " + valueArray[Matrix.MSCALE_Y] + "\n");
        Log.i("dragon", "MTRANS_X = " + valueArray[Matrix.MTRANS_X] + "\n");
        Log.i("dragon", "MTRANS_Y = " + valueArray[Matrix.MTRANS_Y] + "\n");
        Log.i("dragon", "MSKEW_X = " + valueArray[Matrix.MSKEW_X] + "\n");
        Log.i("dragon", "MSKEW_Y = " + valueArray[Matrix.MSKEW_Y] + "\n");
        Log.i("dragon", "MPERSP_0 = " + valueArray[Matrix.MPERSP_0] + "\n");
        Log.i("dragon", "MPERSP_1 = " + valueArray[Matrix.MPERSP_1] + "\n");
        Log.i("dragon", "MPERSP_2 = " + valueArray[Matrix.MPERSP_2] + "\n");


        matrix.preScale(2, 2);

        matrix.getValues(valueArray);

        Log.i("dragon", "\n" + "preScale(1,1)" + "\n");

        Log.i("dragon", "MSCALE_X = " + valueArray[Matrix.MSCALE_X] + "\n");
        Log.i("dragon", "MSCALE_Y = " + valueArray[Matrix.MSCALE_Y] + "\n");
        Log.i("dragon", "MTRANS_X = " + valueArray[Matrix.MTRANS_X] + "\n");
        Log.i("dragon", "MTRANS_Y = " + valueArray[Matrix.MTRANS_Y] + "\n");
        Log.i("dragon", "MSKEW_X = " + valueArray[Matrix.MSKEW_X] + "\n");
        Log.i("dragon", "MSKEW_Y = " + valueArray[Matrix.MSKEW_Y] + "\n");
        Log.i("dragon", "MPERSP_0 = " + valueArray[Matrix.MPERSP_0] + "\n");
        Log.i("dragon", "MPERSP_1 = " + valueArray[Matrix.MPERSP_1] + "\n");
        Log.i("dragon", "MPERSP_2 = " + valueArray[Matrix.MPERSP_2] + "\n");

    }

    public void onClickMatrixDemostration(View view) {
        startActivity(MatrixDemostrationActivity.class);
    }

    private void startActivity(Class<?> activity) {
        startActivity(new Intent(MatrixActivity.this, activity));
    }
}
