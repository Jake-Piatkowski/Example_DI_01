package com.jbpi.exampledi01;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jbpi.exampledi01.data.ApiResponseStreams;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

class StreamsDownloader {

    void download(Consumer<ApiResponseStreams> action) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = okHttpClientBuilder.addInterceptor(httpLoggingInterceptor).build();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
        Retrofit retrofit = retrofitBuilder
                .baseUrl("https://api.twitch.tv/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        TwitchWebApiService twitchWebApiService = retrofit.create(TwitchWebApiService.class);
        Observable<ApiResponseStreams> streamsHomm3 = twitchWebApiService.getStreamsHomm3();

        streamsHomm3.subscribe(action);
    }
}
