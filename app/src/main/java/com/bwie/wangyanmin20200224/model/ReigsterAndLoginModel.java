package com.bwie.wangyanmin20200224.model;

import com.bwie.wangyanmin20200224.contract.IReigsterAndLoginContract;
import com.bwie.wangyanmin20200224.model.bean.LoginBean;
import com.bwie.wangyanmin20200224.model.bean.RegisterBean;
import com.bwie.wangyanmin20200224.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 *@auther:王彦敏
 *@Date: 2020/2/26
 *@Time:17:01
 *@Description:
 * */
public class ReigsterAndLoginModel implements IReigsterAndLoginContract.IModel {
    @Override
    public void getRegister(String phone, String pwd, IRegisterCallback iRegisterCallback) {
        NetUtil.getInstance().getApi().getRegisterHome(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        iRegisterCallback.onReigsterSuccess(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iRegisterCallback.onReigsterFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getLogin(String phone, String pwd, ILoginCallback iLoginCallback) {
            NetUtil.getInstance().getApi().getLoginHome(phone,pwd)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<LoginBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(LoginBean loginBean) {
                            iLoginCallback.onLoginSuccess(loginBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iLoginCallback.onLoginFailure(e);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
    }
}
