package com.example.liubin.cloudread.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.example.liubin.cloudread.app.CloudReaderApplication;

/**
 * Created by zengzhi on 2017/6/23.
 */

public class CommonUtils {

    public static Drawable getDrawable(int resid) {
        return getResoure().getDrawable(resid);
    }

    public static int getColor(int resid) {
        return getResoure().getColor(resid);
    }

    public static Resources getResoure() {
        return CloudReaderApplication.getInstance().getResources();
    }
}
