package com.jiang.android.scalabletabindicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.jiang.android.scalabletabindicator.library.ScalableTabIndicator;
import com.jiang.android.transformer.transformer.RotateTransformer;

public class MainActivity extends AppCompatActivity {


    ScalableTabIndicator mScalableTabIndicator;
    ViewPager pager;
    ViewPagerAdapter adapter;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScalableTabIndicator = (ScalableTabIndicator) this.findViewById(R.id.tabindicator);
        pager = (ViewPager) this.findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setPageTransformer(true, new RotateTransformer());
        pager.setAdapter(adapter);
        mScalableTabIndicator.setViewPager(pager);

        for (int i = 0; i < adapter.getCount(); i++) {
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
            return "Sezione " + position;
        }

    }
}
