package com.lxlt.projectmanagement.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by 苑雪元 on 2016/6/4.
 */
public class ControlScrollViewPager extends ViewPager {
    public ControlScrollViewPager(Context context) {
        super(context);
    }
    public ControlScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
            return false;

    }
}
