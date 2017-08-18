package com.ideal.jalen.canvas.activity.bezier;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;
import com.ideal.jalen.canvas.widget.DrawBoardView;

import butterknife.BindView;

/**
 * @author Jalen
 * @date 2017/8/17
 * @editor
 * @date
 * @describe 画板（使用两阶贝塞尔曲线）
 */
public class DrawBoardActivity extends BaseActivity {

    @BindView(R.id.activity_draw_board_drawBoardView)
    DrawBoardView drawBoardView;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_draw_board;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_draw_board, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_draw_board_reset:
                drawBoardView.reset();
                break;
            case R.id.menu_draw_board_color:
                drawBoardView.changeColor(R.color.common_style_red);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
