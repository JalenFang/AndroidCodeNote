package com.ideal.jalen.material.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;
import com.ideal.jalen.material.activity.appbar.AppBarLayoutActivity;
import com.ideal.jalen.material.activity.dialog.BottomSheetDialogActivity;
import com.ideal.jalen.material.activity.drawer.DrawerLayoutAnimationActivity;
import com.ideal.jalen.material.activity.drawer.DrawerLayoutSimpleActivity;
import com.ideal.jalen.material.activity.fab.FloatingActionButtonActivity;
import com.ideal.jalen.material.activity.palette.PaletteActivity;
import com.ideal.jalen.material.activity.recyclerview.GridActivity;
import com.ideal.jalen.material.activity.recyclerview.LinearHorizontalActivity;
import com.ideal.jalen.material.activity.recyclerview.LinearVerticalActivity;
import com.ideal.jalen.material.activity.recyclerview.StaggeredActivity;
import com.ideal.jalen.material.activity.recyclerview_refresh_autoloadmore.RecyclerViewRefreshAutoLoadMoreActivity;
import com.ideal.jalen.material.activity.refresh.SwipeRefreshLayoutActivity;
import com.ideal.jalen.material.activity.searchview.SearchViewToolbarActivity;
import com.ideal.jalen.material.activity.snackbar.SnackbarActivity;
import com.ideal.jalen.material.activity.tab.TabLayoutBottomActivity;
import com.ideal.jalen.material.activity.tab.TabLayoutTopActivity;
import com.ideal.jalen.material.activity.textinput.TextInputLayoutActivity;
import com.ideal.jalen.material.activity.toolbar.ToolbarActivity;

/**
 * author: Jalen
 * date: 2017/6/23. 17:43
 * describe: MaterialDesign主页面
 */
public class MaterialActivity extends BaseActivity {
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_material;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    public void onClickToolbarBasicUse(View view) {
        startActivity(ToolbarActivity.class);
    }

    public void onClickSnackbar(View view) {
        startActivity(SnackbarActivity.class);
    }

    public void onClickFloatingActionButton(View view) {
        startActivity(FloatingActionButtonActivity.class);
    }

    public void onClickAppBarLayout(View view) {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.select_scroll_flag))
                .setItems(R.array.array_scroll_flag, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent intent = new Intent(getApplicationContext(), AppBarLayoutActivity.class);
                        switch (which) {
                            case 0:
                                intent.putExtra(AppBarLayoutActivity.SCROLL_FLAG, "scroll");
                                break;
                            case 1:
                                intent.putExtra(AppBarLayoutActivity.SCROLL_FLAG, "enterAlways");
                                break;
                            case 2:
                                intent.putExtra(AppBarLayoutActivity.SCROLL_FLAG, "enterAlwaysCollapsed");
                                break;
                            case 3:
                                intent.putExtra(AppBarLayoutActivity.SCROLL_FLAG, "snap");
                                break;
                            case 4:
                                intent.putExtra(AppBarLayoutActivity.SCROLL_FLAG, "exitUntilCollapsed");
                                break;
                            case 5:
                                intent.putExtra(AppBarLayoutActivity.SCROLL_FLAG, "scroll_enterAlways");
                                break;
                            case 6:
                                intent.putExtra(AppBarLayoutActivity.SCROLL_FLAG, "scroll_enterAlways_enterAlwaysCollapsed");
                                break;
                            case 7:
                                intent.putExtra(AppBarLayoutActivity.SCROLL_FLAG, "scroll_exitUntilCollapsed");
                                break;
                            case 8:
                                intent.putExtra(AppBarLayoutActivity.SCROLL_FLAG, "scroll_snap");
                                break;
                            default:
                                break;

                        }
                        startActivity(intent);
                    }
                })
                .show();
    }

    public void onClickBottomSheetDialog(View view) {
        startActivity(BottomSheetDialogActivity.class);
    }

    public void onClickTabLayoutTop(View view) {
        startActivity(TabLayoutTopActivity.class);
    }

    public void onClickTabLayoutBottom(View view) {
        startActivity(TabLayoutBottomActivity.class);
    }

    public void onClickRecyclerViewLinearVertical(View v) {
        startActivity(LinearVerticalActivity.class);
    }

    public void onClickRecyclerViewLinearHorizantal(View v) {
        startActivity(LinearHorizontalActivity.class);
    }

    public void onClickRecyclerViewStaggered(View v) {
        startActivity(StaggeredActivity.class);
    }

    public void onClickRecyclerViewGrid(View v) {
        startActivity(GridActivity.class);
    }

    public void onClickRecyclerViewRefreshAutoLoadMore(View v) {
        startActivity(RecyclerViewRefreshAutoLoadMoreActivity.class);
    }

    public void onClickRecyclerViewDragSwipe(View v) {
        Toast.makeText(this, "待开发", Toast.LENGTH_SHORT).show();
    }


    public void onClickRecyclerViewAnimation(View v) {
        Toast.makeText(this, "待开发", Toast.LENGTH_SHORT).show();
    }

    public void onClickSwipeRefreshLayout(View v) {
        startActivity(SwipeRefreshLayoutActivity.class);
    }

    public void onClickDrawerLayoutSimple(View v) {
        startActivity(DrawerLayoutSimpleActivity.class);
    }

    public void onClickDrawerLayoutAnimation(View v) {
        startActivity(DrawerLayoutAnimationActivity.class);
    }

    public void onClickSearchViewToolbar(View v) {
        startActivity(SearchViewToolbarActivity.class);
    }

    public void onClickTextInputLayout(View v) {
        startActivity(TextInputLayoutActivity.class);
    }

    public void onClickPalette(View v) {
        startActivity(PaletteActivity.class);
    }

    private void startActivity(Class<?> className) {
        startActivity(new Intent(getActivity(), className));
    }
}
