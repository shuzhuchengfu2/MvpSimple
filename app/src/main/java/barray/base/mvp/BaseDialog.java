package barray.base.mvp;


import android.content.DialogInterface;
import android.support.annotation.Nullable;

/**
 * dialog 基类
 */

public interface BaseDialog {
    /**
     * 显示
     */
    void show();

    /**
     * 隐藏
     */
    void dismiss();

    /**
     * 是否显示
     * @return
     */
    boolean isShowing();

    /**
     * 消失监听
     * @param listener
     */
    void setOnDismissListener(@Nullable DialogInterface.OnDismissListener listener);
}
