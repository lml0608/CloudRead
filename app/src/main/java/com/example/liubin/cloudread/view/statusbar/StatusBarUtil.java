package com.example.liubin.cloudread.view.statusbar;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by zengzhi on 2017/6/26.
 */

public class StatusBarUtil {


//
//
//    /**
//     * 为头部是 ImageView 的界面设置状态栏透明
//     *
//     * @param activity       需要设置的activity
//     * @param statusBarAlpha 状态栏透明度
//     * @param needOffsetView 需要向下偏移的 View
//     */
//    public static void setTranslucentForImageView(Activity activity, int statusBarAlpha, View needOffsetView) {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
//            return;
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
//            activity.getWindow()
//                    .getDecorView()
//                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//            if (activity instanceof TabActivity){
//                activity.getWindow()//兼容TabActivity
//                        .setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            }
//        } else {
//            activity.getWindow()
//                    .setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
//        addTranslucentView(activity, statusBarAlpha);
//        if (needOffsetView != null) {
//            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) needOffsetView.getLayoutParams();
//            if (layoutParams != null) {
//                layoutParams.setMargins(0, getStatusBarHeight(activity), 0, 0);
//            }
//        }
//    }
//
//    /**
//     * 获取状态栏高度
//     *
//     * @param context context
//     * @return 状态栏高度
//     */
//    public static int getStatusBarHeight(Context context) {
//        // 获得状态栏高度
//        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
//        return context.getResources().getDimensionPixelSize(resourceId);
//    }

}
