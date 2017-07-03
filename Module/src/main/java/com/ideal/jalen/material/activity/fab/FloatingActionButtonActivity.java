package com.ideal.jalen.material.activity.fab;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;

/**
 * @author Jalen
 * @date 2017/5/8. 17:15
 * @editor
 * @date
 * @describe
 */
public class FloatingActionButtonActivity extends BaseActivity {
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_floating_action_button;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

   /* app:backgroundTint - 设置FAB的背景颜色。
    app:rippleColor - 设置FAB点击时的背景颜色。
    app:borderWidth - 该属性尤为重要，如果不设置0dp，那么在4.1的sdk上FAB会显示为正方形，而且在5.0以后的sdk没有阴影效果。所以设置为borderWidth="0dp"。
    app:elevation - 默认状态下FAB的阴影大小。
    app:pressedTranslationZ - 点击时候FAB的阴影大小。
    app:fabSize - 设置FAB的大小，该属性有两个值，分别为normal和mini，对应的FAB大小分别为56dp和40dp。
    src - 设置FAB的图标，Google建议符合Design设计的该图标大小为24dp。
    app:layout_anchor - 设置FAB的锚点，即以哪个控件为参照点设置位*/
}
