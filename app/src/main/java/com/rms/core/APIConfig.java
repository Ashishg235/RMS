package com.rms.core;

import java.util.concurrent.ExecutorService;

/**
 * Created by Ashish on 9/13/2016.
 */
public class APIConfig {

    private static final String TAG = APIConfig.class.getSimpleName();
    public static final int ERROR_CODE = 501;
    private static ExecutorService scheduler = null;
    private static Object syncRoot = new Object();

    public static final String IMAGE_BASE_URL = "https://rms.com/image/";
    public static final String BASE_URL = "";
}
