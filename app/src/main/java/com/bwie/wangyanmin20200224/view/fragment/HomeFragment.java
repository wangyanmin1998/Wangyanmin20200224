package com.bwie.wangyanmin20200224.view.fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.bwie.wangyanmin20200224.R;
import com.bwie.wangyanmin20200224.base.BaseFragment;
import com.bwie.wangyanmin20200224.contract.IOrderContract;
import com.bwie.wangyanmin20200224.model.bean.OrderBean;
import com.bwie.wangyanmin20200224.prisenter.OrderPresenter;
import com.bwie.wangyanmin20200224.view.adapter.HomeAdapter;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<OrderPresenter> implements IOrderContract.IView {


    @BindView(R.id.recy_home)
    RecyclerView recyHome;
    private int type = 2;
    private int page = 1;
    private int size = 10;

    @Override
    protected void initView(View inflate) {


    }

    @Override
    protected OrderPresenter providePresenter() {
        return new OrderPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        mPresenter.getOrder(type, page, size);
    }



    @Override
    public void onOrderSuccess(OrderBean orderBean) {
        Log.i("xx",orderBean.getMessage());
        List<OrderBean.ResultBean> result = orderBean.getResult();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyHome.setLayoutManager(linearLayoutManager);
        HomeAdapter homeAdapter = new HomeAdapter(result);
        recyHome.setAdapter(homeAdapter);

    }

    @Override
    public void onOrderFailure(Throwable throwable) {

    }
}
