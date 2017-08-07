package com.android.frameproj.library;

/**
 * Created by WE-WIN-027 on 2016/9/27.
 *
 * @des ${TODO}
 */
public class Constants {

    public static final int OK = 0;

    public static String LH_LOG_PATH = "/Log/";// 日志默认保存目录

    public static final String BASE_URL = "http://192.168.1.1";

    // app类型：1:ios,2:andriod
    public static final int APPTYPE = 2;

    //服务端自定义API key、value
    public static String app_key = "B272F43387B8504C";
    public static String app_value = "70BAE8B491362AB39042B77C7653199D";

    //对应HTTP的状态码
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int REQUEST_TIMEOUT = 408;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int BAD_GATEWAY = 502;
    public static final int SERVICE_UNAVAILABLE = 503;
    public static final int GATEWAY_TIMEOUT = 504;


}
