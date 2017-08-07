package com.android.mvvm.frameprojmvvm.ui.test;

/**
 * Created by we-win on 2017/8/7.
 */

public class User {

    public String name;
    public String myBlog;
    public int age;

    public User(String name, String myBlog, int age) {
        this.name = name;
        this.myBlog = myBlog;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
}
