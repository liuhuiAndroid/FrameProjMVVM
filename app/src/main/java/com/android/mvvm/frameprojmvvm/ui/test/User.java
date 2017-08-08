package com.android.mvvm.frameprojmvvm.ui.test;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.android.frameproj.library.util.imageloader.ImageLoaderUtil;

/**
 * Created by we-win on 2017/8/7.
 */

public class User extends BaseObservable {

    public ObservableField<String> name = new ObservableField<>();

    public String myBlog;
    public int age;
    public String imageUrl;
    public boolean isStudent;

    public User(String name, String myBlog, int age, String imageUrl, boolean isStudent) {
        this.name.set(name);
        this.myBlog = myBlog;
        this.age = age;
        this.imageUrl = imageUrl;
        this.isStudent = isStudent;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public String getMyBlog() {
        return myBlog;
    }

    public void setMyBlog(String myBlog) {
        this.myBlog = myBlog;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @BindingAdapter({"loadImage"})
    public static void imageloader(ImageView imageView,String url){
        ImageLoaderUtil.getInstance().loadImage(url,imageView);
    }

}
