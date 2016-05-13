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

package com.jiang.android.scalabletabindicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiang.android.scalabletabindicator.library.Tab;

/**
 * Created by jiang on 16/5/9.
 */
public class TabView2 extends Tab {

    private final LinearLayout mRootView;
    private final TextView mTab2Tv;

    public TabView2(Context context) {
        mRootView = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.tab2_layout, null);
        mTab2Tv = (TextView) mRootView.findViewById(R.id.tab2_tv);
        mRootView.setClickable(true);
        mRootView.setOnClickListener(this);
    }

    public void setText(String title) {
        mTab2Tv.setText(title);
    }

    @Override
    public void actived() {
        mTab2Tv.setTextColor(mRootView.getResources().getColor(R.color.colorAccent));

    }

    @Override
    public void dismissed() {
        mTab2Tv.setTextColor(mRootView.getResources().getColor(R.color.black));

    }


    @Override
    public View getView() {
        return mRootView;
    }
}
