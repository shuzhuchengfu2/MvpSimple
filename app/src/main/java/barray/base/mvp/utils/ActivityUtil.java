package barray.base.mvp.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Activity 管理类
 */

public class ActivityUtil {
    private static List<Activity> activityList = new ArrayList<>();

    public static void addActivity(Activity activity) {
        if (activity != null) {
            activityList.add(activity);
        }
    }

    public static void removeActivity(Activity activity) {
        if (activity != null) {
            activityList.remove(activity);
        }

    }

    public static void clearAllActivities() {
        activityList.clear();
    }

    /**
     * 关闭activity
     *
     * @param activity
     */
    public static void closeActivity(Activity activity) {
        if (activity != null) {
            activity.finish();
            removeActivity(activity);
        }
    }

    /**
     * 关闭activity
     *
     * @param simpleName
     */
    public static void closeActivity(String simpleName) {
        if (simpleName != null) {
            Iterator<Activity> iter = activityList.iterator();
            while (iter.hasNext()) {
                Activity activity = iter.next();
                if (activity != null && simpleName.equals(activity.getClass().getSimpleName())) {
                    activity.finish();
                    iter.remove();
                }
            }
        }
    }

    /**
     * 关闭activity
     *
     * @param simpleName
     */
    public static void closeAllWithoutActivity(String simpleName) {
        if (simpleName != null) {
            Iterator<Activity> iter = activityList.iterator();
            while (iter.hasNext()) {
                Activity activity = iter.next();
                if (activity != null && !simpleName.equals(activity.getClass().getSimpleName())) {
                    activity.finish();
                    iter.remove();
                }
            }
        }
    }

    /**
     * 退出应用
     *
     * @param activity
     */
    public static void exitApp(Activity activity) {
        if (activity != null) {
            closeAllWithoutActivity(activity.getClass().getSimpleName());
            activity.finish();
            System.exit(0);

        }
    }

    /**
     * 退出应用
     *
     * @param simpleName 父Activity SimpleName
     */
    public static void exitApp(String simpleName) {
        if (simpleName != null) {
            closeAllWithoutActivity(simpleName);
            closeActivity(simpleName);
            System.exit(0);
        }
    }
}
