package barray.base.mvp;

import android.content.DialogInterface;

/**
 * 默认覆写 加载框 , 错误提示
 */
public abstract class AbstractDefaultBaseView<P extends BasePresenter> extends AbstractBaseView<P> {
    protected BaseDialog mDialog;
    /**
     * 加载动画的个数
     */
    private int loadingCount = 0;

    /**
     * 是否显示加载框
     */
    protected boolean isShowLoading = true;

    protected boolean isResume;

    private synchronized void addLoadingCount() {
        loadingCount++;
    }

    private synchronized void reduceLoadingCount() {
        loadingCount--;
    }

    @Override
    public void initDialog() {
        super.initDialog();
        if (!isFragment) {
            mDialog = new LoadingDialog(mActivity);
            mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    loadingCount = 0;
                }
            });
        }
    }


    @Override
    public void dismissLoading() {
        super.dismissLoading();
        // 防止弹框 内存泄漏
        try {
            if (!isFragment) {
                if (isShowLoading) {
                    reduceLoadingCount();
                    if (loadingCount < 0) {
                        loadingCount = 0;
                    }
                    if (loadingCount == 0) {
                        if (mDialog != null && mDialog.isShowing()) {
                            mDialog.dismiss();
                        }
                    }
                }
            } else {
                if (mActivity != null && mActivity instanceof BaseActivity) {
                    BaseActivity baseActivity = (BaseActivity) mActivity;
                    if (baseActivity.getView() != null) {
                        baseActivity.getView().dismissLoading();
                        reduceLoadingCount();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showLoading() {
        super.showLoading();
        // 防止弹框 内存泄漏
        try {
            if (!isFragment) {
                if (isShowLoading && isResume) {
                    if (loadingCount < 0) {
                        loadingCount = 0;
                    }
                    if (loadingCount == 0) {
                        if (mDialog != null && !mDialog.isShowing()) {
                            mDialog.show();
                        }
                    }
                    addLoadingCount();
                }
            } else {
                if (mActivity != null && mActivity instanceof BaseActivity) {
                    BaseActivity baseActivity = (BaseActivity) mActivity;
                    if (baseActivity.getView() != null) {
                        baseActivity.getView().showLoading();
                        addLoadingCount();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showError(String text) {
        super.showError(text);
        ToastUtil.showShort(MyApplication.getContext(),text);
    }

    @Override
    public void onDestroy() {
        if (!isFragment) {
            loadingCount = 0;
            dismissLoading();
        } else {
            if (mActivity != null && mActivity instanceof BaseActivity) {
                BaseActivity baseActivity = (BaseActivity) mActivity;
                if (baseActivity.getView() != null) {
                    if (loadingCount > 0) {
                        for (int i = 0; i < loadingCount; i++) {
                            baseActivity.getView().dismissLoading();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void initToolbar() {
        super.initToolbar();
    }


    @Override
    public void goLogin() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {
        isResume = true;
    }

    @Override
    public void onPause() {
        loadingCount = 0;
        if(!isFragment){
            dismissLoading();
        }else{
            if (mActivity != null && mActivity instanceof BaseActivity) {
                BaseActivity baseActivity = (BaseActivity) mActivity;
                if (baseActivity.getView() != null) {
                    if (loadingCount > 0) {
                        for (int i = 0; i < loadingCount; i++) {
                            baseActivity.getView().dismissLoading();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onStop() {

    }
}
