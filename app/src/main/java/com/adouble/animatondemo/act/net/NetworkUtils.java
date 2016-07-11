package com.adouble.animatondemo.act.net;

import com.adouble.animatondemo.act.bean.RequestResult;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by double on 16-7-10.
 * Project: AnimatonDemo
 */
public class NetworkUtils {

    private static Service service;

    static {
        service = new Retrofit.Builder()
                .baseUrl("http://www.tngou.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Service.class);
    }

    public static Service getService() {
        return service;
    }

    public interface Service {

        @GET("/tnfs/api/list?id=2&page=2")
        Call<RequestResult> getImgs();
    }

}


