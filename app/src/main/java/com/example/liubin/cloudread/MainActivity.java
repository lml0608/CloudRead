package com.example.liubin.cloudread;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.liubin.cloudread.app.ConstansImageUrl;
import com.example.liubin.cloudread.databinding.ActivityMainBinding;
import com.example.liubin.cloudread.databinding.NavHeaderMainBinding;
import com.example.liubin.cloudread.ui.menu.NavHomePageActivity;
import com.example.liubin.cloudread.utils.GlideCircleTransform;

import static com.example.liubin.cloudread.R.id.toolbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(mBinding.include.toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

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

    }


    private void setUpNavigationView() {


        mBinding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.ll_nav_homepage:
                        NavHomePageActivity.startHome(MainActivity.this);
                        mBinding.drawerLayout.closeDrawers();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.home:
                invalidateOptionsMenu();

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
