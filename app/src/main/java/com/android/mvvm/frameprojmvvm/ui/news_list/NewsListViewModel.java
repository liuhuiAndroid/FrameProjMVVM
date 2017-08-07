package com.android.mvvm.frameprojmvvm.ui.news_list;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.mvvm.frameprojmvvm.bean.NewsBean;

import javax.inject.Inject;

/**
 * Created by we-win on 2017/8/7.
 */

public class NewsListViewModel extends BaseObservable {

    @Bindable
    public NewsBean mNewsBean;

    public String title = "";

    @Inject
    public NewsListViewModel() {
    }

    public String getBody() {
        return mNewsBean.getBody();
    }
}
