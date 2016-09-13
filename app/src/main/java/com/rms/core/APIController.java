package com.rms.core;

import com.rms.interfaces.IAPICallback;
import com.rms.utils.ZLogger;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Ashish on 25/12/15.
 */
public class APIController {

    private static final String TAG = APIController.class.getSimpleName();
    private OkHttpClient httpClient;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public APIController(){
        httpClient = new OkHttpClient();
    }

    private void executeGetAPI(final String url, final IAPICallback callback){

        ZLogger.i(TAG,"apicall RMS Get API called with URL : "+url);
        final APIResponse apiResponse = new APIResponse();
        Request request = new Request.Builder()
                .url(url).build();
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                ZLogger.e(TAG,"apicall RMS Get API FAILED for URL : "+url);
                apiResponse.setCode(APIConfig.ERROR_CODE);
                apiResponse.setBody("Request : "+url+" , FAILED");
                callback.onFailure(apiResponse);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()){
                    int code = response.code();
                    ZLogger.e(TAG,"apicall RMS Get API FAILED for URL : "+url+" , with error code :"+code);
                    apiResponse.setCode(code);
                    apiResponse.setBody("Request : "+url+" , FAILED");
                    callback.onFailure(apiResponse);
                }else {
                    int code = response.code();
                    String str = response.body().string();
                    ZLogger.d(TAG,"apicall RMS Get API DISPATCHED for url : "+url+" ,  with response as : "+
                                ", code : "+code+", response : "+str);
                    apiResponse.setCode(code);
                    apiResponse.setBody(str);
                    callback.onSuccess(apiResponse);
                }

                response.body().close();
            }
        });

    }

    private void executePutAPI(final String url, final IAPICallback callback, RequestBody requestBody){

        ZLogger.i(TAG,"apicall RMS Put API called with URL : "+url);
        final APIResponse apiResponse = new APIResponse();
        Request request = new Request.Builder()
                .put(requestBody)
                .url(url).build();
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                ZLogger.e(TAG,"apicall RMS Get API FAILED for URL : "+url);
                apiResponse.setCode(APIConfig.ERROR_CODE);
                apiResponse.setBody("Request : "+url+" , FAILED");
                callback.onFailure(apiResponse);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()){
                    int code = response.code();
                    ZLogger.e(TAG,"apicall RMS Get API FAILED for URL : "+url+" , with error code :"+code);
                    apiResponse.setCode(code);
                    apiResponse.setBody("Request : "+url+" , FAILED");
                    callback.onFailure(apiResponse);
                }else {
                    int code = response.code();
                    String str = response.body().string();
                    ZLogger.d(TAG,"apicall RMS Get API DISPATCHED for url : "+url+" ,  with response as : "+
                            ", code : "+code+", response : "+str);
                    apiResponse.setCode(code);
                    apiResponse.setBody(str);
                    callback.onSuccess(apiResponse);
                }

                response.body().close();
            }
        });

    }

    private void executePostAPI(final String url, final RequestBody requestBody,final IAPICallback callback){
        ZLogger.i(TAG,"apicall RMS POST API called with URL : "+url);
        final APIResponse apiResponse = new APIResponse();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();


        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                ZLogger.e(TAG,"apicall RMS POST API FAILED for URL : "+url);
                apiResponse.setCode(APIConfig.ERROR_CODE);
                apiResponse.setBody("Request : "+url+" , FAILED");
                callback.onFailure(apiResponse);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()){
                    int code = response.code();
                    ZLogger.e(TAG,"apicall RMS POST API FAILED for URL : "+url+" , with error code :"+code);
                    apiResponse.setCode(code);
                    apiResponse.setBody("Request : "+url+" , FAILED");
                    callback.onFailure(apiResponse);
                }else {
                    int code = response.code();
                    String str = response.body().string();
                    ZLogger.d(TAG,"apicall RMS POST API DISPATCHED for url : "+url+" ,  with response as : "+
                            ", code : "+code+", response : "+str);
                    apiResponse.setCode(code);
                    apiResponse.setBody(str);
                    callback.onSuccess(apiResponse);
                }

                response.body().close();
            }
        });
    }

}
