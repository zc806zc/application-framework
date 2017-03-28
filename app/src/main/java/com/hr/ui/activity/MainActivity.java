package com.hr.ui.activity;

import android.widget.TextView;

import com.hr.R;
import com.hr.base.BaseActivity;
import com.hr.utils.UIUtil;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.text)TextView textView;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        textView.setText(UIUtil.getString(R.string.app_name));
    }
}
