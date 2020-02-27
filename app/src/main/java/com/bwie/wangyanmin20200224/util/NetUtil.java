package com.bwie.wangyanmin20200224.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bwie.wangyanmin20200224.R;
import com.bwie.wangyanmin20200224.weight.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@auther:王彦敏
 *@Date: 2020/2/24
 *@Time:13:48
 *@Description:
 * */
public class NetUtil {
    //公共的接口
    private static final String BASE_URL="http://mobile.bwstudent.com/";
    private final Api api;

    private NetUtil() {
        //日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //ok拦截器
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api = retrofit.create(Api.class);

    }

    public Api getApi() {
        return api;
    }

    //单例
    public static NetUtil getInstance() {
        return SingleHolder.NET_UTIL;
    }
    //私有的静态方法
    private static final class SingleHolder{
        private static final NetUtil NET_UTIL=new NetUtil();
    }

    //无网
    public boolean hasNet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null&&activeNetworkInfo.isAvailable()) {
            return true;

        }else {
            return false;
        }

    }

    public void getPhoto(String httpUrl, ImageView imageView){
        //Glide的加载图片
        Glide.with(imageView).load(httpUrl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);

    }

}
