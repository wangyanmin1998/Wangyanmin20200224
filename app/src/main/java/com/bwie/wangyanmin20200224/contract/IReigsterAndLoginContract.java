package com.bwie.wangyanmin20200224.contract;

import com.bwie.wangyanmin20200224.model.bean.LoginBean;
import com.bwie.wangyanmin20200224.model.bean.RegisterBean;

/*
 *@auther:王彦敏
 *@Date: 2020/2/26
 *@Time:16:44
 *@Description:
 * */
public interface IReigsterAndLoginContract {
    interface IView{
        //注册
        void onReigsterSuccess(RegisterBean registerBean);
        void onReigsterFailure(Throwable throwable);
        //登录
        void onLoginSuccess(LoginBean loginBean);
        void onLoginFailure(Throwable throwable);
    }
    interface IPresenter{
        void getRegister(String phone,String pwd);
        void getLogin(String phone,String pwd);

    }
    interface IModel{
        void getRegister(String phone,String pwd,IRegisterCallback iRegisterCallback);
        void getLogin(String phone,String pwd,ILoginCallback iLoginCallback);
        interface IRegisterCallback{
            //注册
            void onReigsterSuccess(RegisterBean registerBean);
            void onReigsterFailure(Throwable throwable);

        }
        interface ILoginCallback{

            //登录
            void onLoginSuccess(LoginBean loginBean);
            void onLoginFailure(Throwable throwable);
        }

    }


}
