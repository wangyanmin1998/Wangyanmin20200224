package com.bwie.wangyanmin20200224.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

/*
 *@auther:王彦敏
 *@Date: 2020/2/27
 *@Time:16:27
 *@Description:
 * */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    //创建一个P来继承BasePresenter实现BasePresenter中的方法
    protected P mPresenter;
    //创建
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());

        mPresenter=providePresenter();
        //attach
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        //初始化数据
        ButterKnife.bind(this);
        //方法
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P providePresenter();

    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            //detach方法
            mPresenter.detach();
        }
    }
}
