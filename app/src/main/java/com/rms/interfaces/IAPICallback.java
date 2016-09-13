package com.rms.interfaces;


import com.rms.core.APIResponse;

/**
 * Created by Ashish on 9/13/2016.
 */
public interface IAPICallback {
    void onSuccess(APIResponse apiResponse);
    void onFailure(APIResponse apiResponse);
}
