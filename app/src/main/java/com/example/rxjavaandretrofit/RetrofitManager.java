package com.example.rxjavaandretrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager implements IRetrofitManager {

    @Override
    public void get(String url, String number, int page, callback callback) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //实例化网络请求接口
        sisterapi_Interface sisterapi_interface=retrofit.create(sisterapi_Interface.class);
        //封装发送请求
        Call<Sister> call=sisterapi_interface.getcall(number, page);
        //发送网络请求
        call.enqueue(new Callback<Sister>() {
            //请求成功时调用
            @Override
            public void onResponse(Call<Sister> call, Response<Sister> response) {

            }
            //请求失败时调用
            @Override
            public void onFailure(Call<Sister> call, Throwable t) {

            }
        });
    }
}
