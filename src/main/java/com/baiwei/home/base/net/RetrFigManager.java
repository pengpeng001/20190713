package com.baiwei.home.base.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrFigManager {
    private static volatile RetrFigManager retrFigManager;

    private OkHttpClient mClient;

    private Retrofit mRetrofit;

    private RetrFigManager(){
        initRetrofig();

    }

    private void initRetrofig() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(20 , TimeUnit.SECONDS);
        builder.readTimeout( 20 , TimeUnit.SECONDS);
        builder.writeTimeout(20 , TimeUnit.SECONDS);
        mClient = builder.build();


        mRetrofit = new Retrofit.Builder()
                .client(mClient)
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public <T> T reCraect(Class<T> service){
        return mRetrofit.create(service);
    }

    public static RetrFigManager getInstance(){
        if (retrFigManager == null){
            synchronized (RetrFigManager.class){
                if (retrFigManager == null){
                    retrFigManager = new RetrFigManager();
                }
            }
        }
        return retrFigManager;
    }

}
