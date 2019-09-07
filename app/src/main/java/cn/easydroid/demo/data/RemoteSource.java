package cn.easydroid.demo.data;

import cn.easydroid.retrofit.RetrofitManager;
import retrofit2.Retrofit;

/**
 * Create Date: 2019/9/5
 * Author: Yang Du
 * Description:
 */
public class RemoteSource {
    private static String domain = "http://appweb.test.cztec.com";

    public static void setDomain(String domain) {
        RemoteSource.domain = domain;
    }

    public static String getDomain() {
        return domain;
    }

    public static void init() {
        Retrofit retrofit = RetrofitManager.getRetrofitManager().getRetrofit(getDomain());
        ApiHolder.apis = retrofit.create(DefaultApi.class);
    }

    private static class ApiHolder {
        private static DefaultApi apis;
    }

    public static <T> T getService(Class<T> clazz) {
        if (clazz == null) {
            return null;
        }
        if (clazz.getSimpleName().equals(DefaultApi.class.getSimpleName())) {
            return (T) ApiHolder.apis;
        }

        return (T) ApiHolder.apis;
    }

}
