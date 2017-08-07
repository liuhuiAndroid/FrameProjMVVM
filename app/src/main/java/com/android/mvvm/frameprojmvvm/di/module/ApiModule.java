package com.android.mvvm.frameprojmvvm.di.module;

import com.android.mvvm.frameprojmvvm.api.common.CommonApi;
import com.android.mvvm.frameprojmvvm.components.retrofit.RequestHelper;
import com.android.mvvm.frameprojmvvm.components.storage.UserStorage;
import com.android.mvvm.frameprojmvvm.di.PerApp;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by WE-WIN-027 on 2016/9/27.
 *
 * @des ${TODO}
 */
@Module
public class ApiModule {

    @Provides
    @PerApp
    public CommonApi providesCookieApi(@Named("api") OkHttpClient okHttpClient,RequestHelper requestHelper,
                                       UserStorage userStorage) {
        return new CommonApi(okHttpClient,requestHelper,userStorage);
    }

}
