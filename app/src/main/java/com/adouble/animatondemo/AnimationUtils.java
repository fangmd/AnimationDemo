package com.adouble.animatondemo;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by double on 16-7-4.
 * Project: AnimatonDemo
 */
public class AnimationUtils {

    public static Animation getTranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, int duration) {
        TranslateAnimation translateAnimation = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
        translateAnimation.setDuration(duration);
        return translateAnimation;
    }


}
