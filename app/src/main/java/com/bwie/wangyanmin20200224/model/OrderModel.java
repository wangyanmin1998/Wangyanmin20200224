package com.bwie.wangyanmin20200224.model;

import com.bwie.wangyanmin20200224.contract.IOrderContract;
import com.bwie.wangyanmin20200224.model.bean.OrderBean;
import com.bwie.wangyanmin20200224.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 *@auther:王彦敏
 *@Date: 2020/2/24
 *@Time:13:55
 *@Description:
 * */
public class OrderModel implements IOrderContract.IModel {
    @Override
    public void getOrder(int type, int page, int size, IOrderCallback iOrderCallback) {
        NetUtil.getInstance().getApi().getOrder(2,"15820947584182",type,page,size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OrderBean orderBean) {
                        iOrderCallback.onOrderSuccess(orderBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iOrderCallback.onOrderFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
