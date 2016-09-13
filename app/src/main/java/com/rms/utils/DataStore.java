package com.rms.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashwani on 31/10/15.
 */
public class DataStore {

    public static final String STORE_BASE_NAME = "data_store_common_preferences";

    // SharedPreferences are singletons and cached process-wide,
    // but, a getSP requires a stat(). so, do it once.
    protected static Map<String, SharedPreferences> sharedPrefs =
            new HashMap<String, SharedPreferences>(5);

    private static String getStoreNameBase() {
        return STORE_BASE_NAME;
    }

    protected static SharedPreferences getSharedPreferences(Context context,
                                                            String storeName) {
        if (sharedPrefs.get(storeName) == null) {
            synchronized (sharedPrefs) {
                sharedPrefs.put(storeName,
                        context.getSharedPreferences(storeName,
                                Context.MODE_PRIVATE));
            }
        }
        return sharedPrefs.get(storeName);
    }

    // we can support a number of different stores internally

    public static String getKeyValueStoreName() {
        return getStoreNameBase() + "_misc";
    }

    public static String getString(Context context, String key, String defaultValue) {
        SharedPreferences s = getSharedPreferences(context, getKeyValueStoreName());
        return s.getString(key, defaultValue);
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences s = getSharedPreferences(context, getKeyValueStoreName());
        SharedPreferences.Editor e = s.edit();
        if (value == null) {
            e.remove(key);
        } else {
            e.putString(key, value);
        }
        e.commit();
    }

    public static void putBoolean(Context context, String key, Boolean value) {
        SharedPreferences s = getSharedPreferences(context, getKeyValueStoreName());
        SharedPreferences.Editor e = s.edit();
        e.putBoolean(key, value);
        e.commit();
    }

    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        SharedPreferences s = getSharedPreferences(context, getKeyValueStoreName());
        return s.getBoolean(key, defaultValue);
    }

    public static void putInt(Context context, String key, int value) {
        SharedPreferences s = getSharedPreferences(context, getKeyValueStoreName());
        SharedPreferences.Editor e = s.edit();
        e.putInt(key, value);
        e.commit();
    }

    public static void putLong(Context context, String key, Long value) {
        SharedPreferences s = getSharedPreferences(context, getKeyValueStoreName());
        SharedPreferences.Editor e = s.edit();
        e.putLong(key, value);
        e.commit();
    }

    public static int getInt(Context context, String key) {
        SharedPreferences s = getSharedPreferences(context, getKeyValueStoreName());
        return s.getInt(key, -1);
    }

    public static Long getLong(Context context, String key) {
        SharedPreferences s = getSharedPreferences(context, getKeyValueStoreName());
        return s.getLong(key, -1);
    }

    public static Long getLong(Context context, String key, long defaultValue) {
        SharedPreferences s = getSharedPreferences(context, getKeyValueStoreName());
        return s.getLong(key, defaultValue);
    }

    public static void putDouble(Context context, String key, double value){
        SharedPreferences s = getSharedPreferences(context, getKeyValueStoreName());
        SharedPreferences.Editor e = s.edit();
        e.putLong(key, Double.doubleToRawLongBits(value));
        e.commit();
    }

    public static Double getDouble(Context context, String key, double defaultValue){
        SharedPreferences s = getSharedPreferences(context, getKeyValueStoreName());
        return Double.longBitsToDouble(s.getLong(key, Double.doubleToLongBits(defaultValue)));
    }

}
