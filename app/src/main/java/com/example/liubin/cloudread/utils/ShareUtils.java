package com.example.liubin.cloudread.utils;

import android.content.Context;
import android.content.Intent;

import com.example.liubin.cloudread.R;

/**
 * Created by zengzhi on 2017/6/26.
 */

public class ShareUtils {

    public static void share(Context context, int stringRes) {
        share(context, context.getString(stringRes));
    }

    public static void share(Context context, String extraText) {


        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.action_share));
        intent.putExtra(Intent.EXTRA_TEXT, extraText);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(
                Intent.createChooser(intent, context.getString(R.string.action_share)));

    }


}
