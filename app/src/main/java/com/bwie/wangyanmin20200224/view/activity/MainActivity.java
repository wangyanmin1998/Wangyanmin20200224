package com.bwie.wangyanmin20200224.view.activity;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.bwie.wangyanmin20200224.R;
import com.bwie.wangyanmin20200224.base.BaseActivity;
import com.bwie.wangyanmin20200224.base.BasePresenter;
import com.bwie.wangyanmin20200224.view.fragment.HomeFragment;
import com.bwie.wangyanmin20200224.view.fragment.OrderFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.vp)
    ViewPager vp;
    private List<Fragment> list=new ArrayList<>();
    @Override
    protected void initData() {
        HomeFragment homeFragment = new HomeFragment();
        OrderFragment orderFragment = new OrderFragment();
        list.add(homeFragment);
        list.add(orderFragment);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem(1);
                        break;
                }
            }
        });

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
        return R.layout.activity_main;
    }


}
