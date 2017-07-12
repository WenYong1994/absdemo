package com.example.warehouse.abswymode.activity;

import android.os.Bundle;

public abstract class BaseActivity extends RxActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initContentView());
        initData();
    }

    protected abstract int initContentView();

    protected abstract void initData();

}
