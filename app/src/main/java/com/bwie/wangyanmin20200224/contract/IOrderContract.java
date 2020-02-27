package com.bwie.wangyanmin20200224.contract;

import com.bwie.wangyanmin20200224.model.bean.OrderBean;

/*
 *@auther:王彦敏
 *@Date: 2020/2/24
 *@Time:13:40
 *@Description:
 * */
public interface IOrderContract {
    interface IView{
        void onOrderSuccess(OrderBean orderBean);
        void onOrderFailure(Throwable throwable);
    }
    interface IPresenter{
        void getOrder(int type,int page,int size);
    }
    interface IModel{
        void getOrder(int type,int page,int size,IOrderCallback iOrderCallback);
        interface IOrderCallback{
            void onOrderSuccess(OrderBean orderBean);
            void onOrderFailure(Throwable throwable);
        }
    }

}
