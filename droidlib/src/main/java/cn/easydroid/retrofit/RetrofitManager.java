package cn.easydroid.retrofit;

import android.os.Environment;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import cn.easydroid.retrofit.Interceptor.LogInterceptor;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static final int TIME_OUT_SECONDS = 10;
    private static final long CACHE_SIZE_MAX = 50 * 1024 * 1024;

    private static RetrofitManager retrofitManager;

    private Map<String, Retrofit> retrofitMap = new HashMap<>();
    private Map<String, OkHttpClient> clientMap = new HashMap<>();


    private List<Interceptor> interceptorList = new ArrayList<>();
    private ArrayList<String> oneNetList = new ArrayList<>();


    private RetrofitManager() {

    }

    public ArrayList<String> getOneNetList() {
        return oneNetList;
    }


    public static RetrofitManager getRetrofitManager() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (retrofitManager == null) {
                    retrofitManager = new RetrofitManager();
                }
            }
        }
        return retrofitManager;
    }


    public Retrofit getRetrofit(String baseUrl) {
        Retrofit retrofit = retrofitMap.get(baseUrl);
        if (retrofit != null) {
            return retrofit;
        }
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient(baseUrl))
                .build();
        retrofitMap.put(baseUrl, retrofit);
        return retrofit;
    }


    private OkHttpClient getOkHttpClient(String baseUrl) {
        OkHttpClient okHttpClient = clientMap.get(baseUrl);
        if (okHttpClient != null) {
            return okHttpClient;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

                //设置缓存文件路径，和文件大小
        builder.cache(new Cache(new File(Environment.getExternalStorageDirectory() + "/okhttp_cache/"), CACHE_SIZE_MAX))
                .connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .addInterceptor(new LogInterceptor());
        for (Interceptor interceptor : interceptorList) {
            if (interceptor != null) {
                builder.addInterceptor(interceptor);
            }
        }
        okHttpClient = builder.build();
        clientMap.put(baseUrl, okHttpClient);
        return okHttpClient;
    }

    public static void addInterceptor(Interceptor interceptor) {
        if (interceptor != null) {
            retrofitManager.interceptorList.add(interceptor);
        }
    }

}
