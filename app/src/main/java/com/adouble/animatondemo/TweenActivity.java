package com.adouble.animatondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TweenActivity extends AppCompatActivity {

    @BindView(R.id.tween_start)
    Button mTweenStart;
    @BindView(R.id.tween_stop)
    Button mTweenStop;
    @BindView(R.id.tween_img)
    ImageView mTweenImg;
    private Animation mAnimation;
    private TranslateAnimation mTranslateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        ButterKnife.bind(this);

        // load xml animation
        mAnimation = AnimationUtils.loadAnimation(this, R.anim.tween_alpha);

        // code implement animation
        mTranslateAnimation = new TranslateAnimation(0, 100, 0, 100);
        mTranslateAnimation.setDuration(1000);

    }

    @OnClick({R.id.tween_start, R.id.tween_stop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tween_start:
//                mTweenImg.startAnimation(mAnimation);
                mTweenImg.startAnimation(mTranslateAnimation);
                break;
            case R.id.tween_stop:

                break;
        }
    }
}
