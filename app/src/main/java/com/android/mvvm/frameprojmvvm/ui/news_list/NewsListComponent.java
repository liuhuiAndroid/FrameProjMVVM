package com.android.mvvm.frameprojmvvm.ui.news_list;


import com.android.mvvm.frameprojmvvm.di.PerActivity;
import com.android.mvvm.frameprojmvvm.di.component.ApplicationComponent;
import com.android.mvvm.frameprojmvvm.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by we-win on 2017/7/21.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface NewsListComponent {
    void inject(NewsListActivity activity);
}
