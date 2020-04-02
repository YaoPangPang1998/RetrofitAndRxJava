package com.example.rxjavaandretrofit;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface sisterapi_Interface {
    @GET("{nmber}/{page}")
    Call <Sister> getcall(@Path("number")  String number, @Path("page") int page);
}
