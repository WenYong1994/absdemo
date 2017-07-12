package com.example.warehouse.abswymode.activity;

import android.os.Bundle;

public abstract class BackActivity extends BaseBackActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initView());
    }

    protected abstract int initView();

    protected abstract void initData();
}
