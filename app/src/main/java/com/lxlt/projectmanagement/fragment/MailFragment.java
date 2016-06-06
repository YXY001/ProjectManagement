package com.lxlt.projectmanagement.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.lxlt.projectmanagement.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MailFragment extends Fragment implements View.OnClickListener {

    private EditText Txt_mail_fragment_user,Txt_mail_fragment_password,Txt_mail_fragment_verification_code;
    private TextView TView_mail_fragment_get_verification_code;
    private String S_user,S_password,S_verificationCode;
    public MailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mail, container, false);

        //初始化界面
        initView(view);

        //初始化点击事件
        click();

        return view;
    }
    /**
     * 初始化点击事件
     */
    private void click() {
        this.TView_mail_fragment_get_verification_code.setOnClickListener(this);
    }

    /**
     * 初始化界面
     */
    private void initView(View view) {
        this.Txt_mail_fragment_user = (EditText) view.findViewById(R.id.Txt_mail_fragment_user);
        this.Txt_mail_fragment_password = (EditText) view.findViewById(R.id.Txt_mail_fragment_password);
        this.Txt_mail_fragment_verification_code = (EditText) view.findViewById(R.id.Txt_mail_fragment_verification_code);
        this.TView_mail_fragment_get_verification_code = (TextView) view.findViewById(R.id.TView_mail_fragment_get_verification_code);
    }

    /**
     * 获取数据
     */
    private void getValues(){
        S_user = this.Txt_mail_fragment_user.getText().toString().trim();
        S_password = this.Txt_mail_fragment_password.getText().toString().trim();
        S_verificationCode = this.Txt_mail_fragment_verification_code.getText().toString().trim();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.TView_tel_fragment_get_verification_code:
                getValues();
                break;
        }
    }
}
