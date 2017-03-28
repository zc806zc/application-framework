package com.hr.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import com.hr.utils.ActivityManager;

import butterknife.ButterKnife;


/**
 *
 * Created by zhangjutao on 16/9/18.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected BaseActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        //绑定butterknife
        ButterKnife.bind(this);
        mActivity = this;
        ActivityManager.getInstance().add(mActivity);
        init();
    }

    protected abstract int getLayoutRes();

    protected abstract void init();
    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            if(getCurrentFocus()!=null && getCurrentFocus().getWindowToken()!=null){
                InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
        return super.onTouchEvent(event);
    }

}
