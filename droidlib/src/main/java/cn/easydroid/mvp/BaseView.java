package cn.easydroid.mvp;

import com.trello.rxlifecycle2.LifecycleTransformer;


public interface BaseView {

    //如果不显示通过presenter调用方法，传参来判断是否显示
     //显示正在加载view
    void showLoading(String message);


   // 关闭正在加载view

    void hideLoading();

    //防止内存泄漏
    LifecycleTransformer bindLifecycle();

}
