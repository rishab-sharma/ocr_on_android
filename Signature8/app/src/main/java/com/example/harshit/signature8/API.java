package com.example.harshit.signature8;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by harshit on 13/10/17.
 */

public interface API {

    String BASE_URL = "http://192.168.0.110:5000/";

    @POST("predict")
    Call<ResultData> getresult(@Body RequestData requestData);



}
