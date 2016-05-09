/**
 * created by jiang, 16/2/28
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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by jiang on 16/2/28.
 */

public class SimpleFragment extends Fragment {

    public static final String BUNDLE_TITLE = "title";
    private String mTitle = "DefaultValue";
    private RelativeLayout mBG;
    private TextView mTitle1;
    private int mPosition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            mTitle = arguments.getString(BUNDLE_TITLE);
            mPosition = arguments.getInt("position");
        }

        View root = inflater.inflate(R.layout.fragment_main, null);
        mBG = (RelativeLayout) root.findViewById(R.id.fragment_bg);
        mTitle1 = (TextView) root.findViewById(R.id.fragment_title);
        return root;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTitle1.setText(mTitle);
        int position = mPosition % 4;
        switch (position) {
            case 0:
                mBG.setBackgroundColor(getResources().getColor(R.color.colorAccent1));
                break;
            case 1:
                mBG.setBackgroundColor(getResources().getColor(R.color.colorAccent2));
                break;
            case 2:
                mBG.setBackgroundColor(getResources().getColor(R.color.colorAccent3));
                break;
            case 3:
                mBG.setBackgroundColor(getResources().getColor(R.color.colorAccent4));
                break;
            case 4:
                mBG.setBackgroundColor(getResources().getColor(R.color.colorAccent5));
                break;

        }

    }

    public static SimpleFragment newInstance(String title, int position) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        bundle.putInt("position", position);
        SimpleFragment fragment = new SimpleFragment();

        fragment.setArguments(bundle);

        return fragment;
    }
}
