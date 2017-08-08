package com.android.mvvm.frameprojmvvm.ui.test;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.android.frameproj.library.util.ToastUtil;
import com.android.mvvm.frameprojmvvm.BR;
import com.android.mvvm.frameprojmvvm.R;
import com.android.mvvm.frameprojmvvm.databinding.ActivityTestBinding;
import com.android.mvvm.frameprojmvvm.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by we-win on 2017/8/7.
 * 例子来自于http://blog.csdn.net/donkor_/article/details/54598215，感谢作者
 */

public class TestActivity extends BaseActivity {

    @Override
    public void initInjector() {

        ActivityTestBinding activityTestBinding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        final User user = new User("刘帅",null,3,"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2657539485,3858778876&fm=58&s=79428856C4B42831443E1ED10300D099",
                false);
        activityTestBinding.setUser(user);

        activityTestBinding.setChangeName(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.name.set("哈哈哈");
            }
        });

        activityTestBinding.setMyClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("点击事件触发");
            }
        });

        activityTestBinding.btnLongClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ToastUtil.showToast("长按事件触发");
                return false;
            }
        });

        list = new ArrayList<>();
        loadData();
        MyBaseAdapter<Beauty> adapter = new MyBaseAdapter<>(this,list,R.layout.item_listview, BR.beauty);
        activityTestBinding.setAdapter(adapter);
    }

    private List<Beauty> list;

    public void loadData() {

        Beauty beauty1 = new Beauty("第一个美女", "http://img2.imgtn.bdimg.com/it/u=3988249408,1489015532&fm=21&gp=0.jpg");
        Beauty beauty2 = new Beauty("第二个美女", "http://img4.imgtn.bdimg.com/it/u=2579627311,3580753633&fm=21&gp=0.jpg");
        Beauty beauty3 = new Beauty("第三个美女", "http://img5.imgtn.bdimg.com/it/u=539171541,1245868076&fm=23&gp=0.jpg");
        Beauty beauty4 = new Beauty("第四个美女", "http://img1.imgtn.bdimg.com/it/u=3494499027,4116428522&fm=23&gp=0.jpg");
        Beauty beauty5 = new Beauty("第五个美女", "http://img4.imgtn.bdimg.com/it/u=645329305,336210525&fm=23&gp=0.jpg");
        list.add(beauty1);
        list.add(beauty2);
        list.add(beauty3);
        list.add(beauty4);
        list.add(beauty5);
    }

    @Override
    public void initUiAndListener() {

    }


}
