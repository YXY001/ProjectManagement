package com.lxlt.projectmanagement.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lxlt.projectmanagement.R;
import com.lxlt.projectmanagement.adapter.Main_fragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends Fragment implements View.OnClickListener,ViewPager.OnPageChangeListener {

    private List<Fragment> list_fragment;
    private ViewPager task_viewPager;
    private TextView txt_myCharge,txt_myLaunch;
    private Main_fragmentAdapter myAdapter;
    public TaskFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_task, container, false);
        initView(v);
        //初始化两个界面
        setMyChargeColor();

        click();
        return v;
    }

    /**
     * 初始化界面
     * @param v
     */
    private void initView(View v){
        //TextView
        this.txt_myCharge = (TextView) v.findViewById(R.id.TXt_task_myCharge);
        this.txt_myLaunch = (TextView) v.findViewById(R.id.TXt_task_myLaunch);

        //viewPager
        task_viewPager = (ViewPager) v.findViewById(R.id.task_viewPager);

        //fragment
        MyChargeFragment myChargeFragment = new MyChargeFragment();
        MyLaunchFragment myLaunchFragment = new MyLaunchFragment();
        list_fragment = new ArrayList<>();
        list_fragment.add(myChargeFragment);
        list_fragment.add(myLaunchFragment);
        myAdapter = new Main_fragmentAdapter(getChildFragmentManager(),list_fragment);
        task_viewPager.setAdapter(myAdapter);
    }

    /**
     * 初始化点击事件
     */
    private void click(){
        this.txt_myCharge.setOnClickListener(this);
        this.txt_myLaunch.setOnClickListener(this);
        this.task_viewPager.setOnPageChangeListener(this);
    }
    /**
     * 设置点击我负责的时背景以及字体颜色
     */
    public void setMyChargeColor(){
        this.txt_myLaunch.setBackgroundResource(R.drawable.textview_background_white_right);
        this.txt_myCharge.setBackgroundResource(R.drawable.textview_background_blue_left);
        txt_myCharge.setTextColor(getResources().getColor(R.color.colorWhite));
        txt_myLaunch.setTextColor(getResources().getColor(R.color.colorBlack));
        task_viewPager.setCurrentItem(0);
    }
    /**
     * 设置点击我发起的时背景以及字体颜色
     */
    public void setMyLaunchColor(){
        txt_myLaunch.setBackgroundResource(R.drawable.textview_background_blue_right);
        txt_myCharge.setBackgroundResource(R.drawable.textview_background_white_left);
        txt_myCharge.setTextColor(getResources().getColor(R.color.colorBlack));
        txt_myLaunch.setTextColor(getResources().getColor(R.color.colorWhite));
        task_viewPager.setCurrentItem(1);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.TXt_task_myCharge:
                setMyChargeColor();
                break;
            case R.id.TXt_task_myLaunch:
                setMyLaunchColor();
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                setMyChargeColor();
                break;
            case 1:
                setMyLaunchColor();
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
