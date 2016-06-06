package com.lxlt.projectmanagement.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lxlt.projectmanagement.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Txt_login_user,Txt_login_password;
    private TextView Txt_login_Spassword,Txt_login_forget_password,Txt_login_sign_in;
    private Button Btn_login_login;
    private String S_user,S_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化界面
        initView();

        //初始化点击事件
        click();

        //初始化数据
        initValues();
    }

    /**
     * 初始化界面
     */
    private void initView(){
        this.Txt_login_user = (EditText) findViewById(R.id.Txt_login_user);
        this.Txt_login_password = (EditText) findViewById(R.id.Txt_login_password);
        this.Txt_login_Spassword = (TextView) findViewById(R.id.Txt_login_Spassword);
        this.Txt_login_forget_password = (TextView) findViewById(R.id.Txt_login_forget_password);
        this.Txt_login_sign_in = (TextView) findViewById(R.id.Txt_login_sign_in);
        this.Btn_login_login = (Button) findViewById(R.id.Btn_login_login);
    }

    /**
     * 初始化点击事件
     */
    private void click(){
        this.Txt_login_Spassword.setOnClickListener(this);
        this.Txt_login_forget_password.setOnClickListener(this);
        this.Txt_login_sign_in.setOnClickListener(this);
        this.Btn_login_login.setOnClickListener(this);
    }

    /**
     * 初始化数据
     */
    private void initValues(){

    }

    /**
     * 获取数据
     */
    private void getValues(){
        this.S_user = this.Txt_login_user.getText().toString().trim();
        this.S_password = this.Txt_login_password.getText().toString().trim();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Txt_login_Spassword:
                rememberPwdClick();
                break;
            case R.id.Txt_login_forget_password:
                forgetPwdClick();
                break;
            case R.id.Txt_login_sign_in:
                registerClick();
                break;
            case R.id.Btn_login_login:
                loginClick();
                break;
        }
    }


    /**
     * 记住密码
     */
    private void rememberPwdClick(){

    }

    /**
     * 忘记密码
     */
    private void forgetPwdClick(){

    }

    /**
     * 登录
     */
    private void loginClick(){

    }

    /**
     * 注册
     */
    private void registerClick(){
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
