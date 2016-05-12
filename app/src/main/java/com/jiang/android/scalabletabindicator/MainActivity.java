package com.jiang.android.scalabletabindicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jiang.android.scalabletabindicator.library.ScalableTabIndicator;
import com.jiang.android.transformer.transformer.RotateTransformer;

public class MainActivity extends AppCompatActivity {


    private ScalableTabIndicator mScalableTabIndicator;
    private ViewPager mPager;
    private ViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScalableTabIndicator = (ScalableTabIndicator) this.findViewById(R.id.tabindicator);
        mPager = (ViewPager) this.findViewById(R.id.pager);
        mScalableTabIndicator.setScrollable(true);
        TabView3 tabView3 = new TabView3(this);
        tabView3.setText("语文");
        mScalableTabIndicator.addTab(tabView3);
        TabView3 tabView32 = new TabView3(this);
        tabView32.setText("数学活动");
        mScalableTabIndicator.addTab(tabView32);
        TabView3 tabView33 = new TabView3(this);
        tabView33.setText("英语");
        mScalableTabIndicator.addTab(tabView33);
        TabView3 tabView34 = new TabView3(this);
        tabView34.setText("政治活动");
        mScalableTabIndicator.addTab(tabView34);
        TabView3 tabView35 = new TabView3(this);
        tabView35.setText("地理");
        mScalableTabIndicator.addTab(tabView35);
        TabView3 tabView36 = new TabView3(this);
        tabView36.setText("生物活动");
        mScalableTabIndicator.addTab(tabView36);
        TabView3 tabView37 = new TabView3(this);
        tabView37.setText("体育");
        mScalableTabIndicator.addTab(tabView37);

        TabView3 tabView38 = new TabView3(this);
        tabView38.setText("体育活动");
        mScalableTabIndicator.addTab(tabView38);

        TabView3 tabView39 = new TabView3(this);
        tabView39.setText("体育");
        mScalableTabIndicator.addTab(tabView39);

        TabView3 tabView40 = new TabView3(this);
        tabView40.setText("体育活动活动");
        mScalableTabIndicator.addTab(tabView40);

        TabView3 tabView41 = new TabView3(this);
        tabView41.setText("体育");
        mScalableTabIndicator.addTab(tabView41);

        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPager.setPageTransformer(true, new RotateTransformer());
        mPager.setAdapter(mAdapter);
        mScalableTabIndicator.setViewPager(mPager);

    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        public Fragment getItem(int num) {
            return SimpleFragment.newInstance(num + "", num);
        }

        @Override
        public int getCount() {
            return 11;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return " " + position;
        }

    }
}
