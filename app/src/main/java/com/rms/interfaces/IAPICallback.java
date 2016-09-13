package com.rms.interfaces;


import com.rms.core.APIResponse;

public interface IAPICallback {
    void onSuccess(APIResponse apiResponse);
    void onFailure(APIResponse apiResponse);
}
