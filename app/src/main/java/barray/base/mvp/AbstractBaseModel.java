package barray.base.mvp;

/**
 * model 的抽象类
 */

public abstract class AbstractBaseModel<P extends BasePresenter> implements BaseModel<P> {
    protected P mPresenter;
    @Override
    public void setPresenter(P mPresenter) {
        this.mPresenter = mPresenter;
    }
}
