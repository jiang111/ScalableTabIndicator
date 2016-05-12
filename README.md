# ScalableTabIndicator
### 可定制的Indicator,结合ViewPager使用,当然不通过ViewPager也可以用
[ ![Download](https://api.bintray.com/packages/yuesong/maven/ScalableTabIndicator/images/download.svg) ](https://bintray.com/yuesong/maven/ScalableTabIndicator/_latestVersion)



![](https://raw.githubusercontent.com/jiang111/ScalableTabIndicator/master/art/7.gif)


### 导入
gradle
```
compile 'com.jiang.android.scalabletabindicator:library:@aar'

```


Maven
```
<dependency>
  <groupId>com.jiang.android.scalabletabindicator</groupId>
  <artifactId>library</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```

### 用法

>* 导入项目

  ```
  compile 'com.jiang.android.scalabletabindicator:library:1.0.1'
  
  ```

>* 在layout中加入

  ```xml
   <com.jiang.android.scalabletabindicator.library.ScalableTabIndicator
          android:id="@+id/tabindicator"
          android:layout_width="match_parent"
          android:layout_height=""
          />
  ```

>* 在代码中加入

  ```java
   mScalableTabIndicator = (ScalableTabIndicator) this.findViewById(R.id.tabindicator);
   /*可要可不要,如果你用到了ViewPager那就要,如果没用到ViewPager那就需要初始化的时候调用mScalableTabIndicator.setCurrentIte m(0);然后mScalableTabIndicator需要实现OnItemClickListener接口 */
   mScalableTabIndicator.setViewPager(pager); 
  mScalableTabIndicator.addTab(//TODO...);
  //没有ViewPager的情况下使用下面这两句
    mScalableTabIndicator.setOnClickListener(new ScalableTabIndicator.OnItemClickListener() {
        @Override
         public void onClick(int position) {
        }
    });
  mScalableTabIndicator.setCurrentItem(0);
    
    
  ```

>* 最关键的一步,新建类继承Tab类，并重写相关的方法,在demo中有TabView1,TabView2和TabView3,3个例子。

  ```java
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
  
  ```
>* 注意: 要想知道viewpager回调的进度,可以通过

```java
mScalableTabIndicator.setChangeListener(new ScalableTabIndicator.ChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
```

或者重写Tab类中的

```java
 /**
     * 如若需要对tab的item元素进行相关操作，可重写这个方法
     *
     * @param positionOffset
     * @param positionOffsetPixels
     */
    public void onPageScrolled(float positionOffset, int positionOffsetPixels) {
    }
```

###作者
>* New_Tab - <jyuesong@gmail.com>

###推荐

>* 收集Android你不知道的那些小技巧:https://github.com/jiang111/awesome-android-tips

>* 收集Android studio 常用的插件,请看这里:https://github.com/jiang111/awesome-androidstudio-plugins

>* 收集程序员必备的那些Chrome插件: https://github.com/jiang111/chrome-plugin-recommand

>* 通过RecyclerView实现的联系人: https://github.com/jiang111/IndexRecyclerView

>* 用于学习RxJava操作符的APP: https://github.com/jiang111/RxJavaApp

>* 展示注册进度的view: https://github.com/jiang111/ProgressView

>* 可定制的ViewPagerIndicator: https://github.com/jiang111/ScalableTabIndicator

>* 通过viewpager的滑动来对fragment内的元素进行动画操作: https://github.com/jiang111/ViewPagerTransformer

