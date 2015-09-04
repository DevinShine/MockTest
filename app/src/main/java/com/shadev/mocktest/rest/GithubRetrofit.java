package com.shadev.mocktest.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import java.util.concurrent.TimeUnit;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by devinshine on 15/9/4.
 * retrofit 实例
 */
public class GithubRetrofit {
    final Github service;

    final static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        .serializeNulls()
        .create();

    RequestInterceptor requestInterceptor = request -> request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");

    GithubRetrofit() {
        OkHttpClient client = new OkHttpClient();
        client.setReadTimeout(12, TimeUnit.SECONDS);

        RestAdapter restAdapter = new RestAdapter.Builder().setClient(new OkClient(client))
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setEndpoint("https://api.github.com")
            .setConverter(new GsonConverter(gson))
            .setRequestInterceptor(requestInterceptor)
            .build();
        service = restAdapter.create(Github.class);
    }

    public Github getService() {
        return service;
    }
}
