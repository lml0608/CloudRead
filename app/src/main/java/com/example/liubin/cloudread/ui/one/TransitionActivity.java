package com.example.liubin.cloudread.ui.one;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.liubin.cloudread.MainActivity;
import com.example.liubin.cloudread.R;
import com.example.liubin.cloudread.app.ConstansImageUrl;
import com.example.liubin.cloudread.databinding.ActivityTransitionBinding;
import com.example.liubin.cloudread.utils.CommonUtils;

import java.util.Random;

public class TransitionActivity extends AppCompatActivity {

    private static final String TAG = "TransitionActivity";
    private ActivityTransitionBinding mBinding;

    private boolean animationEnd; //动画结束
    private boolean isIn; //是否进入主页

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_transition);

        int imageId = new Random().nextInt(ConstansImageUrl.TRANSITION_URLS.length);

        //显示默认图片
        mBinding.ivDefaultPic.setImageDrawable(CommonUtils.getDrawable(R.drawable.img_transition_default));

        Glide.with(this)
                .load(ConstansImageUrl.TRANSITION_URLS[imageId])
                .placeholder(R.drawable.img_transition_default)
                .error(R.drawable.img_transition_default)
                .into(mBinding.ivPic);
        String url = "/liubin/haha";


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               mBinding.ivDefaultPic.setVisibility(View.GONE);
            }
        }, 1500);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toMainActivity();
            }
        }, 5000);

        mBinding.tvJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity();
            }
        });

    }



    private void toMainActivity() {

        if (isIn) {
            return;
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out);
        finish();
        isIn = true;
    }


}
