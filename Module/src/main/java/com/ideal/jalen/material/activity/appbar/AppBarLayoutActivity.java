package com.ideal.jalen.material.activity.appbar;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;
import com.ideal.jalen.recyclerview.adapter.RecyclerViewAdapter;
import com.ideal.jalen.utils.ScreenUtils;

import butterknife.BindView;

/**
 * author: Jalen
 * date: 2017/5/9. 11:26
 * describe:
 */

/**
 * 对用scrollFlag的总结
 * 1.scroll
 * Child View 伴随着滚动事件而滚出或滚进屏幕。
 * 注意两点：第一点，如果使用了其他值，必定要使用这个值才能起作用；
 * 第二点：如果在这个child View前面的任何其他Child View没有设置这个值，那么这个Child View的设置将失去作用。
 * 2.enterAlways
 * 快速返回模式。其实就是向下滚动时Scrolling View和Child View之间的滚动优先级问题。
 * 对比scroll和scroll | enterAlways设置，发生向下滚动事件时，前者优先滚动Scrolling View，
 * 后者优先滚动Child View，当优先滚动的一方已经全部滚进屏幕之后，另一方才开始滚动。
 * 3.enterAlwaysCollapsed
 * enterAlways的附加值必须和enterAlways一起使用。这里涉及到Child View的高度和最小高度，
 * 向下滚动时，Child View先向下滚动最小高度值，然后Scrolling View开始滚动，到达边界时，Child View再向下滚动，直至显示完全。
 * 4.exitUntilCollapsed
 * 这里也涉及到最小高度。发生向上滚动事件时，Child View向上滚动退出直至最小高度，
 * 然后Scrolling View开始滚动。也就是，Child View不会完全退出屏幕。
 * 5.snap
 * 简单理解，就是Child View滚动比例的一个吸附效果。
 * 也就是说，Child View不会存在局部显示的情况，
 * 滚动Child View的部分高度，当我们松开手指时，Child View要么向上全部滚出屏幕，
 * 要么向下全部滚进屏幕，有点类似ViewPager的左右滑动。
 */


public class AppBarLayoutActivity extends BaseActivity {

    @BindView(R.id.activity_appbar_layout_recyclerView)
    RecyclerView recyclerView;

    public static final String SCROLL_FLAG = "scroll_flag";
    private String scrollFlag;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_appbar_layout;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {
        scrollFlag = getIntent().getStringExtra(SCROLL_FLAG);
        setScrollFlag();
        initRecyclerView();
    }

    private void setScrollFlag() {
        AppBarLayout.LayoutParams param = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        if (scrollFlag.equals("scroll")) {
            param.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
        } else if (scrollFlag.equals("enterAlways")) {
            param.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        } else if (scrollFlag.equals("enterAlwaysCollapsed")) {
            param.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);
        } else if (scrollFlag.equals("snap")) {
            param.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP);
        } else if (scrollFlag.equals("exitUntilCollapsed")) {
            param.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
        } else if (scrollFlag.equals("scroll_enterAlways")) {
            param.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        } else if (scrollFlag.equals("scroll_enterAlways_enterAlwaysCollapsed")) {
            param.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);
            toolbar.setMinimumHeight(ScreenUtils.dp2px(this, 30));
        } else if (scrollFlag.equals("scroll_exitUntilCollapsed")) {
            param.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
            toolbar.setMinimumHeight(ScreenUtils.dp2px(this, 30));
        } else if (scrollFlag.equals("scroll_snap")) {
            param.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP);
        }
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(AppBarLayoutActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(AppBarLayoutActivity.this);
        recyclerView.setAdapter(adapter);
    }

}
