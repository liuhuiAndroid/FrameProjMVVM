package com.android.mvvm.frameprojmvvm.ui.news_list;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

import com.android.mvvm.frameprojmvvm.R;
import com.android.mvvm.frameprojmvvm.ui.BaseActivity;

import javax.inject.Inject;

/**
 * 新闻列表
 */

public class NewsListActivity extends BaseActivity {

    @Inject
    NewsListViewModel mNewsListViewModel;

    private ViewDataBinding mBinding;

    @Override
    public void initInjector() {
        DaggerNewsListComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build()
                .inject(this);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_news_list);
    }

    @Override
    public void initUiAndListener() {

    }



}
