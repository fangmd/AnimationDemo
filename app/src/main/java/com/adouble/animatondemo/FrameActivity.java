package com.adouble.animatondemo;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrameActivity extends AppCompatActivity {

    @BindView(R.id.frame_start)
    Button mFrameStart;
    @BindView(R.id.frame_stop)
    Button mFrameStop;
    @BindView(R.id.frame_img)
    ImageView mFrameImg;
    @BindView(R.id.frame_img2)
    ImageView mFrameImg2;
    private AnimationDrawable mDrawable;
    private AnimationDrawable mAnimationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        ButterKnife.bind(this);

        // 1. xml 加载动画
        mDrawable = (AnimationDrawable) mFrameImg.getDrawable();

        // 2. code 生成动画
        mAnimationDrawable = new AnimationDrawable();
        mAnimationDrawable.setOneShot(false);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.drawable.ic_account_circle_black_24dp), 100);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.drawable.ic_account_circle_green_24dp), 100);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.drawable.ic_account_circle_blue_24dp), 100);
        mAnimationDrawable.addFrame(getResources().getDrawable(R.drawable.ic_account_circle_red_24dp), 100);
        mFrameImg2.setBackground(mAnimationDrawable);

    }

    @OnClick({R.id.frame_start, R.id.frame_stop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.frame_start:
                mDrawable.start();
                mAnimationDrawable.start();
                break;
            case R.id.frame_stop:
                mDrawable.stop();
                mAnimationDrawable.stop();
                break;
        }
    }
}
