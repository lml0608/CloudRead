package com.example.liubin.cloudread;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.liubin.cloudread.app.ConstansImageUrl;
import com.example.liubin.cloudread.databinding.ActivityMainBinding;
import com.example.liubin.cloudread.databinding.NavHeaderMainBinding;
import com.example.liubin.cloudread.utils.GlideCircleTransform;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        View headerView = mBinding.navView.getHeaderView(0);
//ss
        NavHeaderMainBinding mainBinding =DataBindingUtil.bind(headerView);

        mBinding.navView.setItemIconTintList(null);

        Glide.with(this)
                .load(ConstansImageUrl.IC_AVATAR)
                .crossFade(500)
                .error(R.drawable.ic_avatar_default)
                .transform(new GlideCircleTransform(this))
                .into(mainBinding.ivAvatar);

    }
}
