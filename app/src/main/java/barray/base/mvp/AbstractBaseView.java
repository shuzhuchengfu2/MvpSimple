package barray.base.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.ButterKnife;

/**
 * view 的 抽象类
 *
 */

public abstract class AbstractBaseView<P extends BasePresenter> implements BaseView<P> {
    protected P mPresenter;
    protected Activity mActivity;
    protected boolean isFragment;

    @Override
    public void setPresenter(P mPresenter){
        this.mPresenter = mPresenter;
    }

    @Override
    public void setActivity(Activity mActivity, boolean isFragment){
        this.mActivity = mActivity;
        this.isFragment = isFragment;
    }


    ///////////////////  可以覆写  //////////////////////////

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showError(String text) {

    }

    @Override
    public void initToolbar() {

    }

    @Override
    public void initDialog() {

    }

    @Override
    public void getIntentData(Intent intent) {

    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void bindView(View view) {
        ButterKnife.bind(this,view);
    }
}
