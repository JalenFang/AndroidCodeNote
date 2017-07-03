package com.ideal.jalen.attrsstyle.widget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ideal.jalen.R;
import com.ideal.jalen.utils.ScreenUtils;

/**
 * @author Jalen
 * @date 2017/6/9. 9:59
 * @editor
 * @date
 * @describe 使用自定义属性和自定义样式的view   http://www.jianshu.com/p/61b79e7f88fc
 */

/**
 * 优先级如下：
 * 1.在Xml里面使用单个属性比在my_style里面优先级高
 * 2.my_style的优先级要高于custom_style
 * 3.custom_style的优先级要高于default_style
 */
public class AttrsStyleView extends LinearLayout {

    public AttrsStyleView(Context context) {
        this(context, null);
    }

    public AttrsStyleView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.custom_style);
        //this(context, attrs, 0);
    }

    public AttrsStyleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(context, attrs, R.styleable.custom_attrs, defStyleAttr, R.style.default_style);
        int color1 = tintTypedArray.getColor(R.styleable.custom_attrs_color1, 0xffff0000);
        int color2 = tintTypedArray.getColor(R.styleable.custom_attrs_color2, 0xffff0000);
        int color3 = tintTypedArray.getColor(R.styleable.custom_attrs_color3, 0xffff0000);
        tintTypedArray.recycle();

        int margin = ScreenUtils.dp2px(context, 10);

        TextView textView1 = new TextView(context);
        textView1.setGravity(Gravity.CENTER);
        textView1.setTextColor(ContextCompat.getColor(context, R.color.common_style_blue));
        textView1.setTextSize(14);
        textView1.setText("color1 " + Integer.toHexString(color1));
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, margin, 0, margin);
        addView(textView1, layoutParams);

        TextView textView2 = new TextView(context);
        textView2.setGravity(Gravity.CENTER);
        textView2.setTextColor(ContextCompat.getColor(context, R.color.common_style_blue));
        textView2.setTextSize(14);
        textView2.setText("color2 " + Integer.toHexString(color2));
        LayoutParams layoutParams2 = new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams2.setMargins(0, margin, 0, margin);
        addView(textView2, layoutParams2);

        TextView textView3 = new TextView(context);
        textView3.setGravity(Gravity.CENTER);
        textView3.setTextColor(ContextCompat.getColor(context, R.color.common_style_blue));
        textView3.setTextSize(14);
        textView3.setText("color3 " + Integer.toHexString(color3));
        LayoutParams layoutParams3 = new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams3.setMargins(0, margin, 0, margin);
        addView(textView3, layoutParams3);
    }
}
