package com.android.mvvm.frameprojmvvm.ui.test;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by we-win on 2017/8/8.
 */

public class MyBaseAdapter<T> extends BaseAdapter {

    private List<T> list;
    // item布局的资源id
    private int layoutId;
    // 系统自动生成的
    private int variableId;
    private LayoutInflater mInflater;

    public MyBaseAdapter(Context context, List<T> list, int layoutId, int variableId) {
        this.list = list;
        this.layoutId = layoutId;
        this.variableId = variableId;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding dataBinding;
        if (convertView == null) {
            dataBinding = DataBindingUtil.inflate(mInflater, layoutId, parent, false);
        } else {
            dataBinding = DataBindingUtil.getBinding(convertView);
        }
        dataBinding.setVariable(variableId, list.get(position));

        return dataBinding.getRoot();
    }
}
