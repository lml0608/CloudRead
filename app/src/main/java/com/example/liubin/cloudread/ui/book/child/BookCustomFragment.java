package com.example.liubin.cloudread.ui.book.child;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telecom.PhoneAccount;

/**
 * Created by zengzhi on 2017/6/27.
 */

public class BookCustomFragment extends Fragment {
    private static final String ARG_PARAM = "arg_param";

    public static Fragment newInstance(String param) {
        
        BookCustomFragment fm = new BookCustomFragment();

        Bundle args = new Bundle();
        
        args.putString(ARG_PARAM, param);
        
        fm.setArguments(args);
        
        return fm;
    }
}
