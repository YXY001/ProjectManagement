package com.lxlt.projectmanagement.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lxlt.projectmanagement.R;
import com.lxlt.projectmanagement.adapter.Main_fragmentAdapter;
import com.lxlt.projectmanagement.fragment.MailFragment;
import com.lxlt.projectmanagement.fragment.TelFragment;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener {


    private TextView Tview_register_tel,Tview_register_mail;
    private Button Btn_register;
    private ViewPager VPager_register;
    private List<Fragment> list_fragment;
    private Main_fragmentAdapter myAdapter;
    private static int TAG = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //初始化界面
        initView();
        showTelView();

        //初始化点击事件
        click();
    }

    /**
     * 初始化界面
     */
    private void  initView(){
        this.Tview_register_tel  = (TextView) findViewById(R.id.Tview_register_tel);
        this.Tview_register_mail  = (TextView) findViewById(R.id.Tview_register_mail);
        this.Btn_register  = (Button) findViewById(R.id.Btn_register);
        this.VPager_register  = (ViewPager) findViewById(R.id.VPager_register);

        //初始化fragment
        TelFragment telFragment = new TelFragment();
        MailFragment mailFragment = new MailFragment();
        list_fragment = new ArrayList<>();
        list_fragment.add(telFragment);
        list_fragment.add(mailFragment);
        myAdapter = new Main_fragmentAdapter(getSupportFragmentManager(),list_fragment);
        this.VPager_register.setAdapter(myAdapter);
    }

    private void click(){
        this.Tview_register_tel.setOnClickListener(this);
        this.Tview_register_mail.setOnClickListener(this);
        this.Btn_register.setOnClickListener(this);
        this.VPager_register.setOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Tview_register_tel:
                showTelView();
                break;
            case R.id.Tview_register_mail:
                showMailView();
                break;
            case R.id.Btn_register:
                registerClick();
                break;
        }
    }

    /**
     * 显示手机注册时的界面
     */
    private void showTelView(){
        this.Tview_register_mail.setBackgroundResource(R.drawable.textview_background_white_right);
        this.Tview_register_tel.setBackgroundResource(R.drawable.textview_background_blue_left);
        this.Tview_register_tel.setTextColor(getResources().getColor(R.color.colorWhite));
        this.Tview_register_mail.setTextColor(getResources().getColor(R.color.colorBlack));
        this.VPager_register.setCurrentItem(0);
        TAG = 0;
    }

    /**
     * 显示手机注册时的界面
     */
    private void showMailView(){
        this.Tview_register_tel.setBackgroundResource(R.drawable.textview_background_white_left);
        this.Tview_register_mail.setBackgroundResource(R.drawable.textview_background_blue_right);
        this.Tview_register_mail.setTextColor(getResources().getColor(R.color.colorWhite));
        this.Tview_register_tel.setTextColor(getResources().getColor(R.color.colorBlack));
        this.VPager_register.setCurrentItem(1);
        TAG =1;
    }

    /**
     * 注册按钮的点击事件
     */
    private void registerClick(){
        if (TAG==0){
            Toast.makeText(RegisterActivity.this,"手机号注册成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(RegisterActivity.this,"邮箱注册成功",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                showTelView();
                break;
            case 1:
                showMailView();
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
