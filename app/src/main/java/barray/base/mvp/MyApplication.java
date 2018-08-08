package barray.base.mvp;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static Context CONTEXT;

    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT = this.getApplicationContext();
    }

    public static Context getContext(){
        return CONTEXT;
    }
}
