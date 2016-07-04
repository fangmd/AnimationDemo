package com.adouble.animatondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_frame)
    Button mFrame;
    @BindView(R.id.main_tween)
    Button mTween;
    @BindView(R.id.main_object)
    Button mObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTitle("Android动画");
    }

    @OnClick({R.id.main_frame, R.id.main_tween, R.id.main_object})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_frame:
                startActivity(new Intent(this, FrameActivity.class));
                break;
            case R.id.main_tween:
                startActivity(new Intent(this, TweenActivity.class));
                break;
            case R.id.main_object:
                break;
        }
    }
}
