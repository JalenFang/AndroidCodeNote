package com.ideal.jalen.material.activity.toolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.ideal.jalen.R;


/**
 * @author Jalen
 * @date 2017/5/8. 11:35
 * @editor
 * @date
 * @describe Toolbar的基本使用
 */
public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_toolbar);

        toolbar.inflateMenu(R.menu.menu_toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.toolbar_menu_serach:
                        Toast.makeText(ToolbarActivity.this, R.string.menu_search, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.toolbar_menu_notification:
                        Toast.makeText(ToolbarActivity.this, R.string.menu_notifications, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.toolbar_menu_item_01:
                        Toast.makeText(ToolbarActivity.this, R.string.item_01, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.toolbar_menu_item_02:
                        Toast.makeText(ToolbarActivity.this, R.string.item_02, Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

}
