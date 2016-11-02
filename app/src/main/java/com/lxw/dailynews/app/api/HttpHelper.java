package com.lxw.dailynews.app.api;

import com.lxw.dailynews.app.bean.LatestNewsBean;
import com.lxw.dailynews.app.bean.NewThemeBean;
import com.lxw.dailynews.app.bean.SplashPictureInfoBean;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;

/**
 * Created by lxw9047 on 2016/10/20.
 */

public class HttpHelper {

    public static final String BASE_URL = "http://news-at.zhihu.com/api/";
    private static final int DEFAULT_TIMEOUT = 5;
    private  Retrofit retrofit;
    public static HttpService httpService;
    public static HttpHelper httpHelper = new HttpHelper();

    private HttpHelper(){
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        httpService = retrofit.create(HttpService.class);
    }
    public static HttpHelper getInstance(){
        return httpHelper;
    }

    public Observable<SplashPictureInfoBean> getSplashPictureInfo(){
        return httpService.getSplashPictureInfo();
    }
    public Observable<LatestNewsBean> getLatestNews(){
        return httpService.getLatestNews();
    }
    public Observable<LatestNewsBean> getBeforeNews(String beforeDate){
        return httpService.getBeforeNews(beforeDate);
    }
    public Observable<NewThemeBean> getNewThemes(){
        return httpService.getNewThemes();
    }
}
