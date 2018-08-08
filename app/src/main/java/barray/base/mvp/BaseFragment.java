package barray.base.mvp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import barray.base.mvp.utils.LogUtil;

public abstract class BaseFragment <V extends BaseView, M extends BaseModel> extends Fragment implements BasePresenter<V, M>{
    protected M mModel;
    protected V mView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.i(this.getClass().getSimpleName(), "== onCreate ==");
        initViewAndModel();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView != null) {
            return inflater.inflate(mView.getLayoutId(), container, false);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            if (mView != null) {
                mView.setActivity(getActivity(),true);
                mView.bindView(view);
                mView.getIntentData(getActivity() == null ? null : getActivity().getIntent());
                mView.initToolbar();
                mView.initDialog();
                mView.initData(savedInstanceState);
            }
        } catch (Exception e) {
            LogUtil.w(this.getClass().getSimpleName(), "== onViewCreated ==",e);
        }
    }


    @Override
    public void onStart() {
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
    public void onResume() {
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
    public void onPause() {
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
    public void onStop() {
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
    public void onDestroyView() {
        super.onDestroyView();
        try {
            if (mView != null) {
                mView.onDestroy();
                mView = null;
                mModel = null;
            }
        } catch (Exception e) {
            LogUtil.w(this.getClass().getSimpleName(), "== onDestroyView ==", e);
        }
    }

    @SuppressWarnings("unchecked")
    private void initViewAndModel() {
        try {
            mModel = createModel().newInstance();
        } catch (java.lang.InstantiationException e) {
            throw new RuntimeException("create Model error");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("create Model error");
        }

        try {
            mView = createView().newInstance();
        } catch (java.lang.InstantiationException e) {
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

    protected abstract Class<V> createView();

    protected abstract Class<M> createModel();
}
