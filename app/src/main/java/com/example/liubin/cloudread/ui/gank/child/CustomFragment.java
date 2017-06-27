package com.example.liubin.cloudread.ui.gank.child;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liubin.cloudread.R;
import com.example.liubin.cloudread.databinding.FragmentCustomBinding;

/**
 * Created by zengzhi on 2017/6/27.
 */

public class CustomFragment extends Fragment {

    private FragmentCustomBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_custom, container, false);

        return mBinding.getRoot();

    }
}
