package com.lxlt.projectmanagement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
    private TextView Tview_register_tel,Tview_register_mail,Tview_register_clear,Tview_register_title;
    private Button Btn_register;
    private ViewPager VPager_register;
    private List<Fragment> list_fragment;
    private Main_fragmentAdapter myAdapter;
    private static int TAG = 0;
    private Toolbar toolbar;
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
        this.Tview_register_clear  = (TextView) findViewById(R.id.Tview_register_clear);
        this.Tview_register_title  = (TextView) findViewById(R.id.Tview_register_title);
        this.Btn_register  = (Button) findViewById(R.id.Btn_register);
        this.VPager_register  = (ViewPager) findViewById(R.id.VPager_register);
        this.toolbar = (Toolbar) findViewById(R.id.register_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

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
        this.Tview_register_clear.setOnClickListener(this);
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
            case R.id.Tview_register_clear:
                back();
                break;
        }
    }

    /**
     * 点击clear按钮时的点击事件
     */
    private void back(){
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
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
        this.Tview_register_title.setText("手机注册");
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
        this.Tview_register_title.setText("邮箱注册");
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
