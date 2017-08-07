package com.android.mvvm.frameprojmvvm.components.storage;

import android.content.Context;
import android.text.TextUtils;

import com.android.mvvm.frameprojmvvm.util.SPUtil;


/**
 * Created by we-win on 2017/7/25.
 */

public class UserStorage {

    private Context mContext;
    private SPUtil mSPUtil;

    public UserStorage(Context context, SPUtil spUtil) {
        this.mContext = context;
        this.mSPUtil = spUtil;
    }

    private String token;

    public String getToken() {
        if(token!=null && !TextUtils.isEmpty(token)) {
            return token;
        }else{
            token = mSPUtil.getTOKNE();
            return mSPUtil.getTOKNE();
        }
    }

    public void setToken(String token) {
        this.token = token;
        mSPUtil.setTOKNE(token);
    }


    public boolean isLogin() {
        return !TextUtils.isEmpty(token) || (!TextUtils.isEmpty(mSPUtil.getTOKNE()));
    }

    public void logout(){
        token = "";
        mSPUtil.setTOKNE("");
    }
}
