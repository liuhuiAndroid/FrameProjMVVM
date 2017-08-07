package com.android.mvvm.frameprojmvvm.ui;

import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.android.frameproj.library.AppManager;
import com.android.frameproj.library.util.ToastUtil;
import com.android.mvvm.frameprojmvvm.MyApplication;
import com.android.mvvm.frameprojmvvm.R;
import com.android.mvvm.frameprojmvvm.api.common.CommonApi;
import com.android.mvvm.frameprojmvvm.di.component.ApplicationComponent;
import com.android.mvvm.frameprojmvvm.di.module.ActivityModule;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import butterknife.ButterKnife;
import retrofit2.HttpException;

import static com.android.frameproj.library.Constants.BAD_GATEWAY;
import static com.android.frameproj.library.Constants.FORBIDDEN;
import static com.android.frameproj.library.Constants.GATEWAY_TIMEOUT;
import static com.android.frameproj.library.Constants.INTERNAL_SERVER_ERROR;
import static com.android.frameproj.library.Constants.NOT_FOUND;
import static com.android.frameproj.library.Constants.REQUEST_TIMEOUT;
import static com.android.frameproj.library.Constants.SERVICE_UNAVAILABLE;
import static com.android.frameproj.library.Constants.UNAUTHORIZED;


/**
 * Created by WE-WIN-027 on 2016/9/27.
 *
 * @des ${TODO}
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //注入数据库
        getApplicationComponent().inject(this);
        initTheme();
        super.onCreate(savedInstanceState);
        initInjector();
        ButterKnife.bind(this);
        initUiAndListener();
        AppManager.getAppManager().addActivity(this);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((MyApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    private void initTheme() {

    }

    /**
     * 注入Injector
     */
    public abstract void initInjector();

    /**
     * init UI && Listener
     */
    public abstract void initUiAndListener();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }

    /**
     * 打开新的Activity
     *
     * @param cls
     */
    public void openActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    /**
     * 设置返回键
     *
     * @param imageView
     */
    public void setImgBack(ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void loadError(Throwable throwable) {
        throwable.printStackTrace();
        if (throwable instanceof CommonApi.APIException) {
            ToastUtil.showToast(throwable.getMessage());
        } else if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            switch (httpException.code()) {
                case UNAUTHORIZED:
                case FORBIDDEN:
                    //                    onPermissionError(ex);          //权限错误，需要实现
                    ToastUtil.showToast(getResources().getString(R.string.error_permission));
                    break;
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    //均视为网络错误
                    ToastUtil.showToast(getResources().getString(R.string.error_network));
                    break;
            }
        } else if (throwable instanceof JsonParseException
                || throwable instanceof JSONException
                || throwable instanceof ParseException) {
            ToastUtil.showToast(getResources().getString(R.string.error_parse));
        } else if (throwable instanceof UnknownHostException) {
            ToastUtil.showToast(getResources().getString(R.string.error_network));
        } else if (throwable instanceof SocketTimeoutException) {    //超时
//            ToastUtil.showToast(getResources().getString(R.string.error_overtime));
        } else {
//            ToastUtil.showToast(getResources().getString(R.string.error_unknow));
        }
    }

}
