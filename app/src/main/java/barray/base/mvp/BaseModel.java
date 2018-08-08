package barray.base.mvp;

/**
 * model 接口
 * @param <P>
 */
public interface BaseModel<P extends BasePresenter> {
    void setPresenter(P mPresenter);
}
