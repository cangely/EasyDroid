package cn.easydroid.retrofit.Interceptor;


import android.util.Log;


import java.io.IOException;

import cn.easydroid.android.log.XLog;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;


public class LogInterceptor implements Interceptor {
    public static final String TAG = "LogInterceptor";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        logRequest(request);
        Response response = chain.proceed(request);
        return logResponse(response,request.url().toString());
    }


    private void logRequest(Request request) {
        try {
            String url = request.url().toString();
            Headers headers = request.headers();
            XLog.v(TAG, "url : " + url);
            XLog.v(TAG, "method : " + request.method());
            if (headers != null && headers.size() > 0) {
                XLog.v(TAG, "headers : " + headers.toString());
            }
            RequestBody requestBody = request.body();
            if (requestBody != null) {
                MediaType mediaType = requestBody.contentType();
                if (mediaType != null) {
                    if (isText(mediaType)) {
                        XLog.v(TAG, "params : " + bodyToString(request));
                    } else {
                        XLog.v(TAG, "params : " + " maybe [file part] , too large too print , ignored!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response logResponse(Response response, String url) {
        try {
            Response.Builder builder = response.newBuilder();
            Response clone = builder.build();
            ResponseBody body = clone.body();
            if (body != null) {
                MediaType mediaType = body.contentType();
                if (mediaType != null) {
                    if (isText(mediaType)) {
                        String resp = body.string();
//                        Log.json(XLog.vEBUG, TAG, resp);
//                        XLog.v(TAG, "json:" + resp);
                        XLog.i(TAG, "URL: " + url);
                        XLog.json(Log.VERBOSE, TAG, resp);
                        XLog.i(TAG, "Response code: " + response.code());

//                        FileIO.writeInFileByfb("/sdcard/logjson.json",resp);
                        body = ResponseBody.create(mediaType, resp);
                        return response.newBuilder().body(body).build();
                    } else {
                        XLog.v(TAG, "data : " + " maybe [file part] , too large too print , ignored!");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


    private boolean isText(MediaType mediaType) {
        if (mediaType == null) return false;

        return ("text".equals(mediaType.subtype())
                || "json".equals(mediaType.subtype())
                || "xml".equals(mediaType.subtype())
                || "html".equals(mediaType.subtype())
                || "webviewhtml".equals(mediaType.subtype())
                || "x-www-form-urlencoded".equals(mediaType.subtype()));
    }

    private String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "something error when show requestBody.";
        }
    }

}
