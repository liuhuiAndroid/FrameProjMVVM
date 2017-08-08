package com.android.mvvm.frameprojmvvm.ui.test;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.android.frameproj.library.util.imageloader.ImageLoaderUtil;

/**
 * Created by we-win on 2017/8/8.
 */

public class Beauty {

    public String name;
    public String imageUrl;

    public Beauty(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @BindingAdapter({"beautyImage"})
    public static void beautyImageload(ImageView imageView,String url){
        ImageLoaderUtil.getInstance().loadImage(url,imageView);
    }

}
