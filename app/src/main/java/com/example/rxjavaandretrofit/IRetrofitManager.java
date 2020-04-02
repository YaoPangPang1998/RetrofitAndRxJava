package com.example.rxjavaandretrofit;

import java.net.URL;

import javax.security.auth.callback.Callback;

public interface IRetrofitManager {
     void get(String url, String number, int page, callback callback);
}