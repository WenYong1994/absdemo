package com.example.warehouse.abswymode.activity;

import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;

public abstract class BaseActivity extends RxActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImmersionBar.with(this).init(); //初始化，默认透明状态栏和黑色导航栏
        setContentView(initContentView());
        initData();

    }

    protected abstract int initContentView();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy(); //不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
    }
}
