package com.bwie.wangyanmin20200224.weight;

import com.bwie.wangyanmin20200224.model.bean.LoginBean;
import com.bwie.wangyanmin20200224.model.bean.OrderBean;
import com.bwie.wangyanmin20200224.model.bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*
 *@auther:王彦敏
 *@Date: 2020/2/24
 *@Time:13:44
 *@Description:
 * */
public interface Api {
    //注册
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegisterBean> getRegisterHome(@Field("phone")String phone,@Field("pwd")String pwd);

    //登录
    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginBean> getLoginHome(@Field("phone")String phone,@Field("pwd")String pwd);


    @GET("live-user/verify/findGiftRecordByUid")
    Observable<OrderBean> getOrder(@Header("userId")int userId, @Header("sessionId")String sessionId
                                    , @Query("type")int type,@Query("page")int page,@Query("size")int size);
}
