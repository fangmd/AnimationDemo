package com.adouble.animatondemo.act.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * recyclerView滑动,标题上向隐藏的时候,低栏向下隐藏; 标题出来的时候,低栏也出来.
 *
 * Created by double on 16-7-11.
 * Project: AnimatonDemo
 */
public class BottomBarBehavior extends CoordinatorLayout.Behavior<View> {

    private static final String TAG = BottomBarBehavior.class.getName();

    public BottomBarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        //这个方法是说明这个子控件是依赖AppBarLayout的
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float translationY = Math.abs(dependency.getTop());//获取更随布局的顶部位置
        Log.d(TAG, translationY + "跟随布局的顶部位置");
        // 向下移动
        child.setTranslationY(translationY);
        return true;
    }
}
