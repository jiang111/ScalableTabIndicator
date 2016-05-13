/**
 * created by jiang, 16/5/12
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
 * Created by jiang on 16/5/12.
 */
public class TabView3 extends Tab {


    private Context mContext;
    private final LinearLayout mRoot;
    private final TextView mTab3;
    private final View mTab3Line;

    public TabView3(Context context) {
        this.mContext = context;
        mRoot = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.tab3_layout, null);
        mTab3 = (TextView) mRoot.findViewById(R.id.tab3_tv);
        mTab3Line = mRoot.findViewById(R.id.tab3_tv_line);
        mRoot.setClickable(true);
        mRoot.setOnClickListener(this);
    }

    public void setText(String text) {
        mTab3.setText(text);
    }

    @Override
    public void actived() {
        mTab3.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
        mTab3.setTextSize(18);
        mTab3Line.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissed() {
        mTab3.setTextColor(mContext.getResources().getColor(R.color.black));
        mTab3.setTextSize(14);
        mTab3Line.setVisibility(View.GONE);

    }


    @Override
    public View getView() {
        return mRoot;
    }

    @Override
    public void onPageScrolled(float positionOffset, int positionOffsetPixels) {
        super.onPageScrolled(positionOffset, positionOffsetPixels);
    }
}
