package barray.base.mvp.utils;

import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

import barray.base.mvp.MyApplication;

/**
 * 基本数据类型的工具类
 */

public class BasicTypeUtil {
    public static Long strToLong(String str){
        if(BasicTypeUtil.isEmpty(str)){
            return 0L;
        }
        try{
            return Long.parseLong(str);
        }catch (Exception e){
            return 0L;
        }
    }

    public static Long intToLong(Integer i){
        if(i == null){
            return 0L;
        }
        return i.longValue();
    }

    public static Float intToFloat(Integer i){
        if(i == null){
            return 0f;
        }
        return i.floatValue();
    }


    public static float strToFloat(String str){
        if(BasicTypeUtil.isEmpty(str)){
            return 0f;
        }
        try{
            return Float.parseFloat(str);
        }catch (Exception e){
            return 0f;
        }
    }

    public static int strToInt(String str){
        if(BasicTypeUtil.isEmpty(str)){
            return 0;
        }
        try{
            return Integer.parseInt(str);
        }catch (Exception e){
            return 0;
        }
    }

    public static int floatToInt(Float f){
        if(f == null){
            return 0;
        }
        return f.intValue();
    }


    public static long floatToLong(Float f){
        if(f == null){
            return 0L;
        }
        return f.longValue();
    }

    /**
     * 判断是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(CharSequence str){
        return str == null || str.length() == 0 || "null".equals(str);
    }


    /**
     * 获取string
     * @param stringId
     * @return
     */
    @NonNull
    public static String getString(@StringRes int stringId){
       return MyApplication.getContext().getString(stringId);
    }

    /**
     * 获取颜色
     * @param colorId
     * @return
     */
    @ColorInt
    public static int getColor(@ColorRes int colorId){
        return ContextCompat.getColor(MyApplication.getContext(), colorId);
    }
}
