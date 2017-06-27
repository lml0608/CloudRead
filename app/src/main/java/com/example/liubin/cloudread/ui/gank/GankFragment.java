package com.example.liubin.cloudread.ui.gank;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liubin.cloudread.R;
import com.example.liubin.cloudread.databinding.FragmentGankBinding;
import com.example.liubin.cloudread.ui.gank.child.AndroidFragment;
import com.example.liubin.cloudread.ui.gank.child.CustomFragment;
import com.example.liubin.cloudread.ui.gank.child.EverydayFragment;
import com.example.liubin.cloudread.ui.gank.child.WelfareFragment;
import com.example.liubin.cloudread.view.MyFragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by zengzhi on 2017/6/27.
 */

public class GankFragment extends Fragment {

    private ArrayList<String> mTitleList = new ArrayList<>(4);
    private ArrayList<Fragment> mFragments = new ArrayList<>(4);

    private FragmentGankBinding mBinding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_gank, container, false);


        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getChildFragmentManager(),mFragments, mTitleList);
        mBinding.vpGank.setAdapter(adapter);

        mBinding.vpGank.setOffscreenPageLimit(3);
        adapter.notifyDataSetChanged();

        mBinding.tabGank.setTabMode(TabLayout.MODE_FIXED);
        mBinding.tabGank.setupWithViewPager(mBinding.vpGank);

        return mBinding.getRoot();
    }

    private void initFragmentList() {
        mTitleList.add("每日推荐");
        mTitleList.add("福利");
        mTitleList.add("干货订制");
        mTitleList.add("大安卓");
        mFragments.add(new EverydayFragment());
        mFragments.add(new WelfareFragment());
        mFragments.add(new CustomFragment());
        mFragments.add(AndroidFragment.newInstance("Android"));
    }
}
