package com.bwie.wangyanmin20200224.base;

/*
 *@auther:王彦敏
 *@Date: 2020/2/27
 *@Time:16:24
 *@Description:
 * */
public abstract class BasePresenter<V> {
    protected  V view;

    public void attach(V view) {
        this.view = view;
    }
    public void detach(){
        view=null;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
