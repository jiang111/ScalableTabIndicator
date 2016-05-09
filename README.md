# ScalableTabIndicator
ScalableTabIndicator
### 可定制性很高的Indicator,结合ViewPager展示

![](https://raw.githubusercontent.com/jiang111/ScalableTabIndicator/master/art/7.gif)


### 导入
gradle
```
compile 'com.jiang.android.scalabletabindicator:library:1.0.1'

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

>1.导入项目

>2. 在layout中加入
```xml
 <com.jiang.android.scalabletabindicator.library.ScalableTabIndicator
        android:id="@+id/tabindicator"
        android:layout_width="match_parent"
        android:layout_height="120dp"
        android:layout_below="@+id/toolbar"
        />
```

>3. 在代码中加入
```java
 mScalableTabIndicator = (ScalableTabIndicator) this.findViewById(R.id.tabindicator);
 mScalableTabIndicator.setViewPager(pager);
  mScalableTabIndicator.addTab(//TODO...);
```


