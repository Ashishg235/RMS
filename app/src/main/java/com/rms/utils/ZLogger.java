package com.rms.utils;

import android.util.Log;

/**
 * Created by ashwani on 25/12/15.
 */
public class ZLogger {

    private static final int MAX_LOG_TAG_LENGTH = 23;
    private static final boolean ENABLE_LOGS = true;

    private static final boolean DEBUG = ENABLE_LOGS && true;
    private static final boolean VERBOSE = ENABLE_LOGS && true;
    private static final boolean ERROR = ENABLE_LOGS && true;
    private static final boolean WARNING = ENABLE_LOGS && true;
    private static final boolean INFO = ENABLE_LOGS && true;

    public static void d(String TAG, String message){
        if(DEBUG)
            Log.d(makeLogTag(TAG),message);
    }

    public static void v(String TAG, String message){
        if(VERBOSE)
            Log.v(makeLogTag(TAG),message);
    }

    public static void w(String TAG, String message){
        if(WARNING)
            Log.w(makeLogTag(TAG),message);
    }

    public static void e(String TAG, String message){
        if(ERROR)
            Log.e(makeLogTag(TAG),message);
    }

    private static String makeLogTag(String str) {
        if (str.length() > MAX_LOG_TAG_LENGTH) {
            return str.substring(0, MAX_LOG_TAG_LENGTH - 1);
        }
        return str;
    }

    public static void i(String TAG, String message){
        if(INFO)
            Log.i(makeLogTag(TAG),message);
    }
}
