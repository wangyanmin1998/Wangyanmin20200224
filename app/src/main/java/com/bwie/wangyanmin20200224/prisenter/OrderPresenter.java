package com.bwie.wangyanmin20200224.prisenter;

import com.bwie.wangyanmin20200224.base.BasePresenter;
import com.bwie.wangyanmin20200224.contract.IOrderContract;
import com.bwie.wangyanmin20200224.model.OrderModel;
import com.bwie.wangyanmin20200224.model.bean.OrderBean;

/*
 *@auther:王彦敏
 *@Date: 2020/2/24
 *@Time:14:05
 *@Description:
 * */
public class OrderPresenter extends BasePresenter<IOrderContract.IView> implements IOrderContract.IPresenter {

    private OrderModel orderModel;

    @Override
    protected void initModel() {
        orderModel = new OrderModel();
    }

    @Override
    public void getOrder(int type, int page, int size) {
        orderModel.getOrder(type, page, size, new IOrderContract.IModel.IOrderCallback() {
            @Override
            public void onOrderSuccess(OrderBean orderBean) {
                view.onOrderSuccess(orderBean);
            }

            @Override
            public void onOrderFailure(Throwable throwable) {
                view.onOrderFailure(throwable);
            }
        });
    }
}
