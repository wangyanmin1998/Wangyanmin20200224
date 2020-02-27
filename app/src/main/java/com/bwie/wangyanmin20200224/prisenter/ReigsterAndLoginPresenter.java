package com.bwie.wangyanmin20200224.prisenter;

import com.bwie.wangyanmin20200224.base.BasePresenter;
import com.bwie.wangyanmin20200224.contract.IReigsterAndLoginContract;
import com.bwie.wangyanmin20200224.model.ReigsterAndLoginModel;
import com.bwie.wangyanmin20200224.model.bean.LoginBean;
import com.bwie.wangyanmin20200224.model.bean.RegisterBean;

/*
 *@auther:王彦敏
 *@Date: 2020/2/26
 *@Time:17:04
 *@Description:
 * */
public class ReigsterAndLoginPresenter extends BasePresenter<IReigsterAndLoginContract.IView> implements IReigsterAndLoginContract.IPresenter {

    private ReigsterAndLoginModel reigsterAndLoginModel;

    @Override
    protected void initModel() {
        reigsterAndLoginModel = new ReigsterAndLoginModel();
    }

    @Override
    public void getRegister(String phone, String pwd) {
        reigsterAndLoginModel.getRegister(phone, pwd, new IReigsterAndLoginContract.IModel.IRegisterCallback() {
            @Override
            public void onReigsterSuccess(RegisterBean registerBean) {
                view.onReigsterSuccess(registerBean);
            }

            @Override
            public void onReigsterFailure(Throwable throwable) {
                view.onReigsterFailure(throwable);
            }
        });
    }

    @Override
    public void getLogin(String phone, String pwd) {
        reigsterAndLoginModel.getLogin(phone, pwd, new IReigsterAndLoginContract.IModel.ILoginCallback() {
            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                view.onLoginSuccess(loginBean);
            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);
            }
        });
    }
}
