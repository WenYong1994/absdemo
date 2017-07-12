package com.example.warehouse.abswymode.utils;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2017/7/11.
 */

public class EncodingUtils {
    public static String toUtf8(String str) {
        String result = null;
        try {
            result = new String(str.getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch blocke.printStackTrace();

        }
        return result;
    }
}
