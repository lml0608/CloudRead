package com.example.liubin.cloudread.ui.book;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liubin.cloudread.R;
import com.example.liubin.cloudread.databinding.FragmentBookBinding;
import com.example.liubin.cloudread.ui.book.child.BookCustomFragment;
import com.example.liubin.cloudread.view.MyFragmentPagerAdapter;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by zengzhi on 2017/6/27.
 */

public class BookFragment extends Fragment {

    private ArrayList<String> mTitleList = new ArrayList<>(3);
    private ArrayList<Fragment> mFragments = new ArrayList<>(3);

    private FragmentBookBinding mBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View loadView = inflater.inflate(R.layout.fragment_base, null);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_book, container, false);

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getChildFragmentManager(), mFragments, mTitleList);
        mBinding.vpBook.setAdapter(adapter);
        mBinding.vpBook.setOffscreenPageLimit(2);
        adapter.notifyDataSetChanged();
        mBinding.tabBook.setTabMode(TabLayout.MODE_FIXED);

        mBinding.tabBook.setupWithViewPager(mBinding.vpBook);



        return mBinding.getRoot();
    }

    private void initFragmentList() {
        mTitleList.add("文学");
        mTitleList.add("文化");
        mTitleList.add("生活");
        mFragments.add(BookCustomFragment.newInstance("文学"));
        mFragments.add(BookCustomFragment.newInstance("文化"));
        mFragments.add(BookCustomFragment.newInstance("生活"));
    }
}
