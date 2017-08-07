package com.android.mvvm.frameprojmvvm.di.component;

import android.app.Activity;

import com.android.mvvm.frameprojmvvm.di.PerActivity;
import com.android.mvvm.frameprojmvvm.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by WE-WIN-027 on 2016/9/27.
 *
 * @des ${TODO}
 * ComponentA依赖ComponentB，B必须定义带返回值的方法来提供A缺少的依赖
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

}
