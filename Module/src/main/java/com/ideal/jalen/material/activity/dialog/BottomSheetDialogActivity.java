package com.ideal.jalen.material.activity.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ideal.jalen.R;
import com.ideal.jalen.base.BaseActivity;
import com.ideal.jalen.recyclerview.adapter.RecyclerViewAdapter;

/**
 * author: Jalen
 * date: 2017/5/11. 16:19
 * describe:
 */
public class BottomSheetDialogActivity extends BaseActivity {

    private CustomDialog dialog;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_bottom_sheet_dialog;
    }

    @Override
    public void initUI(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bottom_sheets_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bottom_sheet_dialong_show:
                showBottomSheetDialog();
                break;
            case R.id.bottom_sheet_dialong_gone:
                goneBottomSheetDialog();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showBottomSheetDialog() {
        dialog = new CustomDialog(this, getScreenHeight(BottomSheetDialogActivity.this));
        View contentView = View.inflate(this, R.layout.bottom_sheets_layout, null);
        RecyclerView itemView = (RecyclerView) contentView.findViewById(R.id.bottom_sheet_layout_recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        itemView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(BottomSheetDialogActivity.this);
        itemView.setAdapter(adapter);
        dialog.setContentView(contentView);
        dialog.show();
    }

    private void goneBottomSheetDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private static int getScreenHeight(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }
}


