package barray.base.mvp.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Gson 工具类型
 */

public class GsonUtil {
    private static Gson gson;

    private GsonUtil() {
    }

    public static Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public static String objToString(Object object) {
        if (object == null) {
            return null;
        }
        return getGson().toJson(object);
    }

    public static <T> T stringToObject(String json, Class<T> claz) {
        try {
            getGson().fromJson(json, claz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> stringToList(String json, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        if (!BasicTypeUtil.isEmpty(json)) {
            try {
                JsonArray arry = new JsonParser().parse(json).getAsJsonArray();
                for (JsonElement jsonElement : arry) {
                    list.add(new Gson().fromJson(jsonElement, clazz));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
