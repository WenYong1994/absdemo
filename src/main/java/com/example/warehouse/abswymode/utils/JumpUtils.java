package com.example.warehouse.abswymode.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.warehouse.abswymode.R;


/**
 * Created by Administrator on 2017/5/22.
 */

public class JumpUtils {
    public static void gotoActivity(Activity activity, Intent intent){
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_left, R.anim.out_left);
    }

    public static void gotoActivity(Context context, Class<?extends Activity> activityClass){
//        if(activityClass!=Activity.class){
//            return;
//        }
        Intent jum=new Intent();
        jum.setClassName(context,activityClass.getName());
        context.startActivity(jum);
        if(context instanceof Activity){
            ((Activity)context).overridePendingTransition(R.anim.in_left, R.anim.out_left);
        }
    }

    public static void finsh(Activity activity){
        activity.finish();
        activity.overridePendingTransition(R.anim.in_right, R.anim.out_right);
    }

    public static void gotoActivityForResult(Activity activity,Intent intent,int request){
        activity.startActivityForResult(intent,request);
        activity.overridePendingTransition(R.anim.in_right,R.anim.out_left);
    }

}
