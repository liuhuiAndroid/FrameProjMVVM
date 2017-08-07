package com.android.mvvm.frameprojmvvm;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.frameproj.library.util.ToastUtil;
import com.android.frameproj.library.util.log.CrashlyticsTree;
import com.android.frameproj.library.util.log.Logger;
import com.android.frameproj.library.util.log.Settings;
import com.android.mvvm.frameprojmvvm.di.component.ApplicationComponent;
import com.android.mvvm.frameprojmvvm.di.component.DaggerApplicationComponent;
import com.android.mvvm.frameprojmvvm.di.module.ApplicationModule;

/**
 * Created by we-win on 2017/8/6.
 */

public class MyApplication extends Application{

    private ApplicationComponent mApplicationComponent;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();
        initLogger();
        mContext = getApplicationContext();
        new AppError().initUncaught();
        ToastUtil.register(this);

    }

    /**
     * 需要保证ApplicationComponent只有一个实例
     */
    private void initComponent() {
        mApplicationComponent =
                DaggerApplicationComponent.builder()
                        .applicationModule(new ApplicationModule(this)) // 如果Module只有有参构造器，则必须显式传入Module实例。
                        .build();
        mApplicationComponent.inject(this);//现在没有需要在MyApplication注入的对象，所以这句代码可写可不写
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

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public static Context getContext() {
        return mContext;
    }

}
