package com.example.liubin.cloudread;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.liubin.cloudread.app.ConstansImageUrl;
import com.example.liubin.cloudread.databinding.ActivityMainBinding;
import com.example.liubin.cloudread.databinding.NavHeaderMainBinding;
import com.example.liubin.cloudread.ui.book.BookFragment;
import com.example.liubin.cloudread.ui.gank.GankFragment;
import com.example.liubin.cloudread.ui.menu.NavHomePageActivity;
import com.example.liubin.cloudread.ui.one.OneFragment;
import com.example.liubin.cloudread.utils.GlideCircleTransform;
import com.example.liubin.cloudread.view.MyFragmentPagerAdapter;

import java.util.ArrayList;

import static com.example.liubin.cloudread.R.id.toolbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private ActionBarDrawerToggle mDrawerToggle;
    private ViewPager vpContent;
    private ImageView llTitleDou;
    private ImageView llTitleOne;
    private ImageView llTitleGank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(mBinding.include.toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        initView();

        //侧边栏头布局
        View headerView = mBinding.navView.getHeaderView(0);
//ss
        NavHeaderMainBinding mainBinding = DataBindingUtil.bind(headerView);
        //使侧边栏的图标保持原来颜色，不是黑白
        mBinding.navView.setItemIconTintList(null);


        Glide.with(this)
                .load(ConstansImageUrl.IC_AVATAR)
                .crossFade(500)
                .error(R.drawable.ic_avatar_default)
                .transform(new GlideCircleTransform(this))
                .into(mainBinding.ivAvatar);

        setUpNavigationView();

        mDrawerToggle = new ActionBarDrawerToggle(this, mBinding.drawerLayout, mBinding.include.toolbar, R.string.drawer_open,R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                mBinding.include.toolbar.setAlpha(1 - slideOffset / 2);
            }

        };

        mBinding.drawerLayout.setDrawerListener(mDrawerToggle);
        mBinding.drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

        initContentFragment();


    }

    private void initView() {
        //viewpager
        vpContent = mBinding.include.vpContent;
        llTitleGank = mBinding.include.ivTitleGank;
        llTitleOne = mBinding.include.ivTitleOne;
        llTitleDou = mBinding.include.ivTitleDou;
    }

    private void initContentFragment() {

        ArrayList<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new GankFragment());
        mFragmentList.add(new OneFragment());
        mFragmentList.add(new BookFragment());
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);

        vpContent.setAdapter(adapter);
        vpContent.setOffscreenPageLimit(2);
        vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        llTitleGank.setSelected(true);
                        llTitleOne.setSelected(false);
                        llTitleDou.setSelected(false);
                        break;

                    case 1:
                        llTitleGank.setSelected(false);
                        llTitleOne.setSelected(true);
                        llTitleDou.setSelected(false);
                        break;

                    case 2:
                        llTitleGank.setSelected(false);
                        llTitleOne.setSelected(false);
                        llTitleDou.setSelected(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mBinding.include.ivTitleGank.setSelected(true);
        vpContent.setCurrentItem(0);


        //电影栏
        llTitleOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vpContent.getCurrentItem() != 1) {

                    llTitleOne.setSelected(true);
                    llTitleGank.setSelected(false);
                    llTitleDou.setSelected(false);
                    vpContent.setCurrentItem(1);
                }
            }
        });

        llTitleGank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vpContent.getCurrentItem() != 0) {

                    llTitleOne.setSelected(false);
                    llTitleGank.setSelected(true);
                    llTitleDou.setSelected(false);
                    vpContent.setCurrentItem(0);
                }
            }
        });

        llTitleDou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vpContent.getCurrentItem() != 2) {

                    llTitleOne.setSelected(false);
                    llTitleGank.setSelected(false);
                    llTitleDou.setSelected(true);
                    vpContent.setCurrentItem(2);
                }
            }
        });

    }



    private void setUpNavigationView() {


        mBinding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.ll_nav_homepage:
                        NavHomePageActivity.startHome(MainActivity.this);
                        mBinding.drawerLayout.closeDrawers();
                        item.setCheckable(false);
                        return true;
//                    case R.id.ll_nav_scan_download:
//                        NavDownloadActivity.start(MainActivity.this);
//                        return true;
//                    case R.id.ll_nav_deedback:
//                        NavDeedBackActivity.start(MainActivity.this);
//                        return true;
//
//                    case R.id.ll_nav_about:
//                        NavAboutActivity.start(MainActivity.this);
//                        return true;

//                    case R.id.ll_nav_login:
//                        WebViewActivity.loadUrl(v.getContext(), "https://github.com/login", "登录GitHub账号");
//                        return true;

                    case R.id.ll_nav_exit:
                        finish();
                        return true;

                    default:

                }

                if (item.isChecked()) {

                    item.setChecked(false);

                } else {
                    item.setChecked(true);
                }
                item.setChecked(true);
                return true;

            }
        });


    }

    @Override
    public void onBackPressed() {

        if(mBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mBinding.drawerLayout.closeDrawers();
            return;
        }


        super.onBackPressed();
    }


}
