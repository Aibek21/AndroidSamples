package com.example.mvvmsample.data.networking;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static APIService service;

    public static HttpLoggingInterceptor getInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    public static OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    public static Retrofit getRetrofit() {

        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();
    }

    public static APIService getService() {
        if (service == null) {
            service = getRetrofit().create(APIService.class);
        }
        return service;
    }

}
