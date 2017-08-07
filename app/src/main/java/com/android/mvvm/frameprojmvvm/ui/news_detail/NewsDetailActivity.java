package com.android.mvvm.frameprojmvvm.ui.news_detail;

import android.databinding.DataBindingUtil;

import com.android.mvvm.frameprojmvvm.R;
import com.android.mvvm.frameprojmvvm.ui.BaseActivity;

/**
 * 新闻详情
 */

public class NewsDetailActivity extends BaseActivity{

    @Override
    public void initInjector() {
        DataBindingUtil.setContentView(this, R.layout.activity_news_detail);
    }

    @Override
    public void initUiAndListener() {

    }
}
