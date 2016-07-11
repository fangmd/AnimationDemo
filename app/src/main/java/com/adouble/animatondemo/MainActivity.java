package com.adouble.animatondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.adouble.animatondemo.act.BaiduMapActivity;
import com.adouble.animatondemo.act.ListActivity;
import com.adouble.animatondemo.baseanimate.FrameActivity;
import com.adouble.animatondemo.baseanimate.TweenActivity;
import com.adouble.animatondemo.baseanimate.propertyanimation.PropertAct;

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
    @BindView(R.id.main_act_jump)
    Button mMainActJump;
    @BindView(R.id.main_act_jump2)
    Button mMainActJump2;
    @BindView(R.id.main_bottom_sheet_behavior)
    Button mMainBottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTitle("Android动画");

    }


    @OnClick({R.id.main_frame, R.id.main_tween, R.id.main_object, R.id.main_act_jump
            , R.id.main_act_jump2, R.id.main_bottom_sheet_behavior})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_frame:
                startActivity(new Intent(this, FrameActivity.class));
                break;
            case R.id.main_tween:
                startActivity(new Intent(this, TweenActivity.class));
                break;
            case R.id.main_object:
                startActivity(new Intent(this, PropertAct.class));
                break;
            case R.id.main_act_jump:
                startActivity(new Intent(this, ListActivity.class));
                break;
            case R.id.main_act_jump2:
                break;
            case R.id.main_bottom_sheet_behavior:
                startActivity(new Intent(this, BaiduMapActivity.class));
                break;
        }
    }

}
