package com.bwie.wangyanmin20200224.view.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bwie.wangyanmin20200224.R;
import com.bwie.wangyanmin20200224.base.BaseActivity;
import com.bwie.wangyanmin20200224.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingActivity extends BaseActivity {


    @BindView(R.id.img_good)
    ImageView imgGood;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_shopping;
    }


}
