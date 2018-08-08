package barray.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import barray.base.mvp.utils.ActivityUtil;
import barray.base.mvp.utils.LogUtil;

/**
 * Activity 基类
 */
public abstract class BaseActivity<V extends BaseView, M extends BaseModel> extends AppCompatActivity implements BasePresenter<V, M> {
    protected M mModel;
    protected V mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.i(this.getClass().getSimpleName(), "== onCreate ==");
        ActivityUtil.addActivity(this);
        initViewAndModel();
        try {
            View view = LayoutInflater.from(this).inflate(mView.getLayoutId(), null, false);
            setContentView(view);
            mView.setActivity(this, false);
            mView.bindView(view);
            mView.getIntentData(getIntent());
            mView.initToolbar();
            mView.initDialog();
            mView.initData(savedInstanceState);
        } catch (Exception e) {
            LogUtil.w(this.getClass().getSimpleName(), "== onCreate ==", e);
        }
    }

    protected abstract Class<V> createView();

    protected abstract Class<M> createModel();

    @SuppressWarnings("unchecked")
    private void initViewAndModel() {
        try {
            mModel = createModel().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("create Model error");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("create Model error");
        }

        try {
            mView = createView().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("create Model error");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("create Model error");
        }

        if (mModel != null) {
            mModel.setPresenter(this);
        }

        if (mView != null) {
            mView.setPresenter(this);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            if (mView != null) {
                mView.onStart();
            }
        } catch (Exception e) {
            LogUtil.w(this.getClass().getSimpleName(), "== onStart ==", e);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        try {
            if (mView != null) {
                mView.onResume();
            }
        } catch (Exception e) {
            LogUtil.w(this.getClass().getSimpleName(), "== onResume ==", e);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        try {
            if (mView != null) {
                mView.onPause();
            }
        } catch (Exception e) {
            LogUtil.w(this.getClass().getSimpleName(), "== onPause ==", e);
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        try {
            if (mView != null) {
                mView.onStop();
            }
        } catch (Exception e) {
            LogUtil.w(this.getClass().getSimpleName(), "== onStop ==", e);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            if (mView != null) {
                mView.onDestroy();
            }
            mView = null;
            mModel = null;
        } catch (Exception e) {
            LogUtil.w(this.getClass().getSimpleName(), "== onDestroy ==", e);
        }
        ActivityUtil.removeActivity(this);
    }
}
