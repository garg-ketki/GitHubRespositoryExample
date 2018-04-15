package com.example.beautifulcode.data.remote;

import com.example.beautifulcode.utils.AppConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ketkigarg on 20/02/18.
 */

public class NetworkHelper {

  public static Retrofit getRetrofit() {
    Retrofit.Builder builder = new Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
        .client(getOkHttpClient())
        .baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create());
    return builder.build();
  }

  private static OkHttpClient getOkHttpClient() {

    OkHttpClient.Builder builder = new OkHttpClient.Builder()
        .addInterceptor(getHttpLoggingInterceptor())
        .connectTimeout(AppConstants.NETWORK_TIME_OUT, TimeUnit.MILLISECONDS)
        .readTimeout(AppConstants.NETWORK_TIME_OUT, TimeUnit.MILLISECONDS)
        .writeTimeout(AppConstants.NETWORK_TIME_OUT, TimeUnit.MILLISECONDS);
    return builder.build();
  }

  private static HttpLoggingInterceptor getHttpLoggingInterceptor() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return interceptor;
  }
}
