package barray.base.mvp;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * 加载进度框
 */

public class LoadingDialog extends Dialog implements BaseDialog {
    private TextView loadingTip;

    public LoadingDialog(@NonNull Context context) {
        this(context, R.style.DialogTheme);
    }

    public LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.dialog_loading);
        loadingTip = findViewById(R.id.loading_tip);
    }

    /**
     * 设置加载提示语
     * @param loadingString
     */
    public void setLoadingString(String loadingString){
        loadingTip.setText(loadingString);
    }

    @Override
    public void setOnDismissListener(@Nullable OnDismissListener listener) {
        super.setOnDismissListener(listener);
    }
}
