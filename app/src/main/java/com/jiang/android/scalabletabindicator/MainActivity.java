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
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPager.setPageTransformer(true, new RotateTransformer());
        mPager.setAdapter(mAdapter);
        mScalableTabIndicator.setViewPager(mPager);

        for (int i = 0; i < mAdapter.getCount(); i++) {
            if (i % 2 == 0) {
                TabView1 view1 = new TabView1(this);
                view1.setText("第" + i + "个tab");
                mScalableTabIndicator.addTab(view1);
            } else {
                TabView2 view2 = new TabView2(this);
                view2.setText("第" + i + "个tab");
                mScalableTabIndicator.addTab(view2);
            }

        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(5000);
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            mScalableTabIndicator.setCurrentItem(12);
//                        }
//                    });
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

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
            return 21;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return " " + position;
        }

    }
}
