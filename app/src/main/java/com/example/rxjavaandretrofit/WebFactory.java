package com.example.rxjavaandretrofit;

public class WebFactory {
    public IRetrofitManager getRetrofitManager(){
        return new RetrofitManager();
    }
}
