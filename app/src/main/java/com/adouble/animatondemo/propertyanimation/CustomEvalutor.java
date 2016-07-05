package com.adouble.animatondemo.propertyanimation;

import android.animation.TypeEvaluator;

/**
 * Created by double on 16-7-5.
 * Project: AnimatonDemo
 */
public class CustomEvalutor implements TypeEvaluator<Number> {

    @Override
    public Number evaluate(float fraction, Number startValue, Number endValue) {
        float propertyResult = 0;
        /*float startFloat = startValue.floatValue();
        return (startFloat + fraction * (endValue.floatValue() - startFloat));*/
        float s = (startValue.floatValue() + fraction * (endValue.floatValue() - startValue.floatValue()));
        return s;
//        return propertyResult;
    }

}
