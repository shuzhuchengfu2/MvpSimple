package barray.base.mvp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;

public interface BaseView<P extends BasePresenter> {
    /**
     * 显示加载动画
     */
    void showLoading();

    /**
     * 隐藏加载动画
     */
    void dismissLoading();
    /**
     * 显示错误信息
     *
     * @param text
     */
    void showError(String text);

    /**
     * 获取布局资源
     *
     * @return
     */
    @LayoutRes
    int getLayoutId();

    /**
     * 设置标题栏 和 状态栏
     */
    void initToolbar();

    /**
     * 设置加载框
     */
    void initDialog();

    /**
     * 初始化数据
     */
    void initData(@Nullable Bundle savedInstanceState);

    /**
     * 获取传递数据
     */
    void getIntentData(Intent intent);

    /**
     * 登录
     */
    void goLogin();

    void setPresenter(P mPresenter);

    /**
     * 绑定控件
     */
    void bindView(View view);

    /**
     * @param mActivity
     * @param isFragment 是否是fragment的子类
     */
    void setActivity(Activity mActivity, boolean isFragment);

    ///////////////////  生命周期  //////////////////////////

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();
}
