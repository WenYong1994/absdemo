package com.example.warehouse.abswymode.application;

import android.app.Application;

import com.orhanobut.hawk.Hawk;

/**
 * Created by Administrator on 2017/7/10.
 */
/**
 *
 *
 //  ┏┓　　　┏┓
 //┏┛┻━━━┛┻┓
 //┃　　　　　　　┃
 //┃　　　━　　　┃
 //┃　┳┛　┗┳　┃
 //┃　　　　　　　┃
 //┃　　　┻　　　┃
 //┃　　　　　　　┃
 //┗━┓　　　┏━┛
 //   ┃　　　┃   神兽保佑
 //   ┃　　　┃   代码无BUG！
 //   ┃　　　┗━━━┓
 //   ┃　　　　　　　┣┓
 //   ┃　　　　　　　┏┛
 //   ┗┓┓┏━┳┓┏┛
 //     ┃┫┫　┃┫┫
 //     ┗┻┛　┗┻┛
 *
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
    }
}
