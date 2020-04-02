package com.example.rxjavaandretrofit;

public interface callback {
    //成功时返回一个对象
    void onRuccess(Sister sister);
    //失败时返回一个字符串消息
    void  fail(String errMSG);
}
