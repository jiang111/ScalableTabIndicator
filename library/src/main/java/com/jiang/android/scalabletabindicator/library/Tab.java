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

import android.view.View;

/**
 * Created by jiang on 16/5/9.
 */
public abstract class Tab implements View.OnClickListener {

    private boolean checked;
    private int position;
    private ScalableTabIndicator mScalableTabIndicator;

    public boolean isChecked() {
        return checked;
    }

    public void active() {
        checked = true;
        actived();
    }

    public void dismiss() {
        checked = false;
        dismissed();
    }

    /**
     * 当前被选中
     */
    public abstract void actived();

    /**
     * 当前没有被选中
     */
    public abstract void dismissed();

    /**
     * 获取该控件需要的宽度
     * 推荐使用:getMeasuredWidth()>getWidth()?getMeasuredWidth():getWidth()
     *
     * @return
     */
    public abstract int getTabNeededWidth();

    /**
     * 获取view
     *
     * @return
     */
    public abstract View getView();

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ScalableTabIndicator getScalableTabIndicator() {
        return mScalableTabIndicator;
    }

    public void setScalableTabIndicator(ScalableTabIndicator scalableTabIndicator) {
        mScalableTabIndicator = scalableTabIndicator;
    }

    @Override
    public void onClick(View v) {
        mScalableTabIndicator.setCurrentItem(position);
    }

}
