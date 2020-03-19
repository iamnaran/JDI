package com.android.nunu.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import androidx.viewpager.widget.ViewPager;

import java.lang.reflect.Field;

public class ViewPagerCustomDuration extends ClickableViewPager {



    public ViewPagerCustomDuration(Context context) {

        super(context);

        postInitViewPager();

    }



    public ViewPagerCustomDuration(Context context, AttributeSet attrs) {

        super(context, attrs);

        postInitViewPager();

    }



    private ScrollerCustomDuration mScroller = null;



    /**

     * Override the Scroller instance with our own class so we can change the

     * duration

     */

    private void postInitViewPager() {

        try {

            Field scroller = ViewPager.class.getDeclaredField("mScroller");

            scroller.setAccessible(true);

            Field interpolator = ViewPager.class.getDeclaredField("sInterpolator");

            interpolator.setAccessible(true);



            mScroller = new ScrollerCustomDuration(getContext(),

                    (Interpolator) interpolator.get(null));

            scroller.set(this, mScroller);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }



    /**

     * Set the factor by which the duration will change

     */

    public void setScrollDurationFactor(double scrollFactor) {

        mScroller.setScrollDurationFactor(scrollFactor);

    }



    private class ScrollerCustomDuration extends Scroller {



        private double mScrollFactor = 1;





        ScrollerCustomDuration(Context context, Interpolator interpolator) {

            super(context, interpolator);

        }





        /**

         * Set the factor by which the duration will change

         */

        void setScrollDurationFactor(double scrollFactor) {

            mScrollFactor = scrollFactor;

        }



        @Override

        public void startScroll(int startX, int startY, int dx, int dy, int duration) {

            super.startScroll(startX, startY, dx, dy, (int) (duration * mScrollFactor));

        }



    }





    @Override

    public boolean onTouchEvent(MotionEvent ev) {

        try {

            return super.onTouchEvent(ev);

        } catch (IllegalArgumentException ex) {

            ex.printStackTrace();

        }

        return false;

    }



    @Override

    public boolean onInterceptTouchEvent(MotionEvent ev) {

        try {

            return super.onInterceptTouchEvent(ev);

        } catch (IllegalArgumentException ex) {

            ex.printStackTrace();

        }

        return false;

    }





}

