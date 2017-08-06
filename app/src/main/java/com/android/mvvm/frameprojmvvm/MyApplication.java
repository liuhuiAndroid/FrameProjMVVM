package com.android.mvvm.frameprojmvvm;

import android.app.Application;
import android.util.Log;

import com.android.frameproj.library.util.log.CrashlyticsTree;
import com.android.frameproj.library.util.log.Logger;
import com.android.frameproj.library.util.log.Settings;

/**
 * Created by we-win on 2017/8/6.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        initLogger();

    }

    /**
     * 初始化日志功能
     */
    private void initLogger() {
        Logger.initialize(
                new Settings()
                        .isShowMethodLink(true)
                        .isShowThreadInfo(false)
                        .setMethodOffset(0)
                        .setLogPriority(BuildConfig.DEBUG ? Log.VERBOSE : Log.ASSERT)
        );
        if (!BuildConfig.DEBUG) {
            // for release
            Logger.plant(new CrashlyticsTree());
        }
    }

}
