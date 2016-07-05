package com.adouble.animatondemo.propertyanimation;

import android.animation.TimeInterpolator;

/**
 * Created by double on 16-7-5.
 * Project: AnimatonDemo
 */
public class CustomInterpolator implements TimeInterpolator {

    /**
     * 返回插值因子
     *
     * @param input
     * @return
     */
    @Override
    public float getInterpolation(float input) {
        // 下面的设置可以简单的实现加减速的功能
        return input * input;
    }
}
