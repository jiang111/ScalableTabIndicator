/**
 * created by jiang, 16/5/9
 * Copyright (c) 2016, jyuesong@gmail.com All Rights Reserved.
 * *                #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */

package com.jiang.android.scalabletabindicator.library;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jiang on 16/5/9.
 */
public class ScalableTabIndicator extends RelativeLayout implements ViewPager.OnPageChangeListener {

    private static final String TAG = "ScalableTabIndicator";

    /**
     * tabs的数量
     */
    private List<Tab> tabs;
    /**
     * 水平滚动的控件
     */
    private HorizontalScrollView mScrollView;
    private LinearLayout mLinearLayout;
    /**
     * 可滚动性，默认为true
     */
    private boolean scrollable = true;
    /**
     * 当前tab是否被选中
     */
    private int tabSelected;
    /**
     * viewpager
     */
    private ViewPager mViewPager;
    /**
     * 监听viewpager的滚动状态
     */
    private ChangeListener changeListener;

    /**
     * 当前的item被点击了
     */
    private OnItemClickListener mOnClickListener;


    public ScalableTabIndicator(Context context) {
        this(context, null);
    }

    public ScalableTabIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScalableTabIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    /**
     * 初始化操作
     *
     * @param context
     */
    private void init(Context context) {
        mScrollView = new HorizontalScrollView(context);
        mScrollView.setOverScrollMode(HorizontalScrollView.OVER_SCROLL_NEVER);
        mScrollView.setHorizontalScrollBarEnabled(false);
        mLinearLayout = new LinearLayout(context);
        mScrollView.addView(mLinearLayout);
        tabs = new LinkedList<>();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingBottom() - getPaddingTop(), MeasureSpec.EXACTLY);
        for (int i = 0; i < tabs.size(); i++) {
            tabs.get(i).getView().measure(MeasureSpec.UNSPECIFIED, height);
        }
    }

    /**
     * 添加一个view到tab中
     *
     * @param tab
     */
    public void addTab(Tab tab) {
        tabs.add(tab);
        tab.setPosition(tabs.size() - 1);
        tab.setScalableTabIndicator(this);
    }

    /**
     * 进行添加
     */
    public void notifyDataSetChanged() {
        super.removeAllViews();
        mLinearLayout.removeAllViews();

        if (scrollable) {
            if (!needScrollable()) {
                scrollable = false;
            }
        }
        if (!scrollable) {
            int tabWidth = this.getWidth() / tabs.size();
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(tabWidth, HorizontalScrollView.LayoutParams.MATCH_PARENT);
            for (Tab t : tabs) {
                mLinearLayout.addView(t.getView(), params);
            }
        } else {
            for (Tab tab : tabs) {
                LinearLayout.LayoutParams params;
                params = new LinearLayout.LayoutParams(HorizontalScrollView.LayoutParams.WRAP_CONTENT, HorizontalScrollView.LayoutParams.MATCH_PARENT);
                mLinearLayout.addView(tab.getView(), params);
            }

        }

        RelativeLayout.LayoutParams paramsScroll = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        this.addView(mScrollView, paramsScroll);
        this.setSelectedNavigationItem(tabSelected);

    }

    /**
     * 判断需不需要进行滚动
     *
     * @return
     */
    private boolean needScrollable() {

        int width = 0;
        for (int i = 0; i < tabs.size(); i++) {
            width += tabs.get(i).getView().getMeasuredWidth();
        }
        return width > this.getMeasuredWidth() ? true : false;
    }

    private void scrollTo(int position) {
        int totalWidth = 0;
        for (int i = 0; i < position; i++) {
            int width = 0;
            if (scrollable) {
                width = tabs.get(i).getView().getMeasuredWidth();
            } else {
                width = this.getWidth() / tabs.size();

            }
            totalWidth += width;
        }
        final int finalTotalWidth = totalWidth;
        mScrollView.smoothScrollTo(finalTotalWidth, 0);

    }

    @Override
    public void removeAllViews() {
        for (int i = 0; i < tabs.size(); i++) {
            tabs.remove(i);
        }
        mLinearLayout.removeAllViews();
        super.removeAllViews();
    }

    public Tab getCurrentTab() {
        for (int i = 0; i < tabs.size(); i++) {
            if (tabs.get(i).isChecked()) {
                return tabs.get(i);
            }
        }
        return null;
    }

    public void setCurrentItem(int position) {
        if (mViewPager != null) {
            mViewPager.setCurrentItem(position);
        } else {
            setSelectedNavigationItem(position);
            if (mOnClickListener != null) {
                mOnClickListener.onClick(position);
            }

        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (this.getWidth() != 0 && tabs.size() != 0)
            notifyDataSetChanged();
    }

    public void setSelectedNavigationItem(int position) {
        if (position < 0 || position > tabs.size()) {
            throw new RuntimeException("Index out bounds");
        } else {
            for (int i = 0; i < tabs.size(); i++) {
                Tab tab = tabs.get(i);
                if (i == position) {
                    tab.active();
                } else {
                    tabs.get(i).dismiss();
                }
            }
            if (scrollable) {
                scrollTo(position);
            }
            tabSelected = position;
        }
    }

    //***** set get ***//


    public OnItemClickListener getOnClickListener() {
        return mOnClickListener;
    }

    public void setOnClickListener(OnItemClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public ChangeListener getChangeListener() {
        return changeListener;
    }

    public void setChangeListener(ChangeListener changeListener) {
        this.changeListener = changeListener;
    }

    public ViewPager getViewPager() {
        return mViewPager;
    }

    public void setViewPager(ViewPager viewPager) {
        mViewPager = viewPager;
        mViewPager.setOnPageChangeListener(this);
    }

    public boolean isScrollable() {
        return scrollable;
    }

    public void setScrollable(boolean scrollable) {
        this.scrollable = scrollable;
    }

    //*****end set get ***//
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        if (changeListener != null)
            changeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        tabs.get(position).onPageScrolled(positionOffset, positionOffsetPixels);

    }

    @Override
    public void onPageSelected(int position) {
        setSelectedNavigationItem(position);
        if (changeListener != null)
            changeListener.onPageSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (changeListener != null)
            changeListener.onPageScrollStateChanged(state);
    }

    /**
     * 和viewpager的功能一样
     */
    public interface ChangeListener {

        void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);

        void onPageSelected(int position);

        void onPageScrollStateChanged(int state);
    }


    public interface OnItemClickListener {

        void onClick(int position);

    }
}
