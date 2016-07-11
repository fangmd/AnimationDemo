package com.adouble.animatondemo.baseanimate.propertyanimation;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.adouble.animatondemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PropertAct extends AppCompatActivity {


    @BindView(R.id.property_start)
    Button mPropertyStart;
    @BindView(R.id.property_scale)
    Button mPropertyScale;
    @BindView(R.id.property_rotate)
    Button mPropertyRotate;
    @BindView(R.id.property_img)
    ImageView mPropertyImg;
    @BindView(R.id.property_list)
    ListView mPropertyList;
    @BindView(R.id.property_list_animation)
    Button mPropertyListAnimation;
    private int mInt;
    private String TAG = PropertAct.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propert);
        ButterKnife.bind(this);

        initListView();

        ViewPropertyAnimatorCompat animate = ViewCompat.animate(mPropertyImg);


    }

    private void initListView() {
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            datas.add("hahaha:" + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, datas);
        mPropertyList.setAdapter(adapter);
    }


    @OnClick({R.id.property_start, R.id.property_scale, R.id.property_rotate,
            R.id.property_list_animation})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.property_start:
                marginValueAnimator();
                break;
            case R.id.property_scale:
                scaleValueAnimator();
                break;
            case R.id.property_rotate:
                break;
            case R.id.property_list_animation:
                mInt = 0;
                if (mInt % 2 == 0) {
                    hideOrShowAnimator(0, 800);
                } else {
                    hideOrShowAnimator(800, 0);
                }
                mInt++;
                break;
        }
    }








    //------------------------ValueAnimator------------------------------

    /**
     * 使用ValueAnimator 改变View 的margin 值
     */
    public void marginValueAnimator() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, getResources().getDisplayMetrics().widthPixels);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mPropertyImg.getLayoutParams();
                layoutParams.leftMargin = ((int) animation.getAnimatedValue());
                mPropertyImg.setLayoutParams(layoutParams);
            }
        });
        valueAnimator.setDuration(1000);
        valueAnimator.setRepeatCount(3);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setTarget(mPropertyImg);
        valueAnimator.start();
    }

    public void scaleValueAnimator() {
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 0f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 0f);
        ValueAnimator valueAnimator = ValueAnimator.ofPropertyValuesHolder(scaleX, scaleY);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float scaleX1 = (float) animation.getAnimatedValue("scaleX");
                float scaleY1 = (float) animation.getAnimatedValue("scaleY");
                mPropertyImg.setScaleX(scaleX1);
                mPropertyImg.setScaleY(scaleY1);
            }
        });
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new CustomInterpolator());
        valueAnimator.setRepeatCount(3);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setTarget(mPropertyImg);
        valueAnimator.start();
    }

    /**
     * 传入listview 的高度 像素 如何计算高度??
     *
     * @param startValue
     * @param endValue
     */
    public void hideOrShowAnimator(final int startValue, final int endValue) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(100, 0);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                float v = animatedValue / 100f;
                CustomEvalutor customEvalutor = new CustomEvalutor();
                mPropertyList.getLayoutParams().height = customEvalutor.evaluate(v, startValue, endValue).intValue();
                Log.d(TAG, "onAnimationUpdate: " + mPropertyList.getLayoutParams().height);
                mPropertyList.requestLayout();
            }
        });

        valueAnimator.setDuration(2000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setTarget(mPropertyList);
        valueAnimator.start();
    }

    //------------------------end------------------------------


}
