package com.example.warehouse.abswymode.activity;

import android.os.Bundle;

import com.example.warehouse.abswymode.utils.JumpUtils;
import com.gyf.barlibrary.ImmersionBar;

public abstract class BackActivity extends BaseBackActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImmersionBar.with(this).init(); //初始化，默认透明状态栏和黑色导航栏
        setContentView(initView());
        initData();
    }

    protected abstract int initView();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy(); //不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        JumpUtils.finsh(this);
    }
}
