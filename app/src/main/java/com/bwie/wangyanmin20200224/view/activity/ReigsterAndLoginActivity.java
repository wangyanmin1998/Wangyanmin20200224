package com.bwie.wangyanmin20200224.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.wangyanmin20200224.R;
import com.bwie.wangyanmin20200224.base.BaseActivity;
import com.bwie.wangyanmin20200224.contract.IReigsterAndLoginContract;
import com.bwie.wangyanmin20200224.model.bean.LoginBean;
import com.bwie.wangyanmin20200224.model.bean.RegisterBean;
import com.bwie.wangyanmin20200224.prisenter.ReigsterAndLoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReigsterAndLoginActivity extends BaseActivity<ReigsterAndLoginPresenter> implements IReigsterAndLoginContract.IView {

    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.bt_register)
    Button btRegister;
    @BindView(R.id.bt_login)
    Button btLogin;
    private String phone;
    private String pwd;
    private String phone1;
    private String pwd1;

    @Override
    protected void initData() {
        mPresenter.getLogin(phone1,pwd1);
        mPresenter.getRegister(phone,pwd);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected ReigsterAndLoginPresenter providePresenter() {
        return new ReigsterAndLoginPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_reigster_and_login;
    }

    @Override
    public void onReigsterSuccess(RegisterBean registerBean) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReigsterFailure(Throwable throwable) {
        Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ShoppingActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.bt_register, R.id.bt_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_register:
                phone = etPhone.getText().toString();
                pwd = etPwd.getText().toString();

                mPresenter.getRegister(phone, pwd);
                break;
            case R.id.bt_login:
                phone1 = etPhone.getText().toString();
                pwd1 = etPwd.getText().toString();

                mPresenter.getLogin(phone1, pwd1);
                break;
        }
    }
}
