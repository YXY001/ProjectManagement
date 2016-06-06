package com.lxlt.projectmanagement.activity;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.lxlt.projectmanagement.R;
import com.lxlt.projectmanagement.adapter.Main_fragmentAdapter;
import com.lxlt.projectmanagement.fragment.MailListFragment;
import com.lxlt.projectmanagement.fragment.MineFragment;
import com.lxlt.projectmanagement.fragment.ProjectFragment;
import com.lxlt.projectmanagement.fragment.TaskFragment;
import com.lxlt.projectmanagement.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager tab_viewPager;
    private List<Fragment> list_fragment;
    private LinearLayout lLayout_task,lLayout_project,lLayout_mail_list,lLayout_mine;
    private ImageView img_task,img_project,img_mail_list,img_mine;
    private TextView txt_task,txt_project,txt_mail_list,txt_mine;
    private Main_fragmentAdapter myAdapter;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置状态栏颜色
        getWindow().setStatusBarColor(Color.parseColor("#FF8000"));

        //初始化界面
        initView();

        //初始化推送
        initPush();

        //点击事件
        click();

    }

    private void initPush() {
        //Push服务初始化及绑定-- startWork
        PushManager.startWork(getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY,"VjfHAGye5dhEtr8KzSaGgvll");
    }

    private void initView() {
        //Layout
        this.lLayout_task = (LinearLayout) findViewById(R.id.LLayout_tabBar_task);
        this.lLayout_project = (LinearLayout) findViewById(R.id.LLayout_tabBar_project);
        this.lLayout_mail_list = (LinearLayout) findViewById(R.id.LLayout_tabBar_mail_list);
        this.lLayout_mine = (LinearLayout) findViewById(R.id.LLayout_tabBar_mine);

        //TextView
        this.txt_task = (TextView) findViewById(R.id.Txt_tabBar_task);
        this.txt_project = (TextView) findViewById(R.id.Txt_tabBar_project);
        this.txt_mail_list = (TextView) findViewById(R.id.Txt_tabBar_mail_list);
        this.txt_mine = (TextView) findViewById(R.id.Txt_tabBar_mine);

        //ImageView
        this.img_task = (ImageView) findViewById(R.id.Img_tabBar_task);
        this.img_project = (ImageView) findViewById(R.id.Img_tabBar_project);
        this.img_mail_list = (ImageView) findViewById(R.id.Img_tabBar_mail_list);
        this.img_mine = (ImageView) findViewById(R.id.Img_tabBar_mine);

        //viewPager
        tab_viewPager = (ViewPager) findViewById(R.id.tab_viewPager);

        //fragment
        TaskFragment taskFragment = new TaskFragment();
        ProjectFragment projectFragment = new ProjectFragment();
        MailListFragment mailListFragment = new MailListFragment();
        MineFragment mineFragment = new MineFragment();

        list_fragment = new ArrayList<>();

        list_fragment.add(taskFragment);
        list_fragment.add(projectFragment);
        list_fragment.add(mailListFragment);
        list_fragment.add(mineFragment);

        myAdapter = new Main_fragmentAdapter(getSupportFragmentManager(),list_fragment);

        tab_viewPager.setAdapter(myAdapter);
    }

    /**
     * 点击事件
     */
    private void click() {
        this.lLayout_task.setOnClickListener(this);
        this.lLayout_project.setOnClickListener(this);
        this.lLayout_mail_list.setOnClickListener(this);
        this.lLayout_mine.setOnClickListener(this);
    }

    private void showTask(){
        img_task.setImageResource(R.mipmap.lxlt_project_tab_task_orage);
        txt_task.setTextColor(getResources().getColor(R.color.colorOrange));
        img_project.setImageResource(R.mipmap.lxlt_project_tab_project);
        txt_project.setTextColor(getResources().getColor(R.color.colorBlack));
        img_mail_list.setImageResource(R.mipmap.lxlt_project_tab_mail_list);
        txt_mail_list.setTextColor(getResources().getColor(R.color.colorBlack));
        img_mine.setImageResource(R.mipmap.lxlt_project_tab_mine);
        txt_mine.setTextColor(getResources().getColor(R.color.colorBlack));
        tab_viewPager.setCurrentItem(0);
    }

    private void showProject(){
        img_task.setImageResource(R.mipmap.lxlt_project_tab_task);
        txt_task.setTextColor(getResources().getColor(R.color.colorBlack));
        img_project.setImageResource(R.mipmap.lxlt_project_tab_project_orage);
        txt_project.setTextColor(getResources().getColor(R.color.colorOrange));
        img_mail_list.setImageResource(R.mipmap.lxlt_project_tab_mail_list);
        txt_mail_list.setTextColor(getResources().getColor(R.color.colorBlack));
        img_mine.setImageResource(R.mipmap.lxlt_project_tab_mine);
        txt_mine.setTextColor(getResources().getColor(R.color.colorBlack));
        tab_viewPager.setCurrentItem(1);
    }

    private void showMailList(){
        img_task.setImageResource(R.mipmap.lxlt_project_tab_task);
        txt_task.setTextColor(getResources().getColor(R.color.colorBlack));
        img_project.setImageResource(R.mipmap.lxlt_project_tab_project);
        txt_project.setTextColor(getResources().getColor(R.color.colorBlack));
        img_mail_list.setImageResource(R.mipmap.lxlt_project_tab_mail_list_orage);
        txt_mail_list.setTextColor(getResources().getColor(R.color.colorOrange));
        img_mine.setImageResource(R.mipmap.lxlt_project_tab_mine);
        txt_mine.setTextColor(getResources().getColor(R.color.colorBlack));
        tab_viewPager.setCurrentItem(2);
    }

    private void showMine(){
        img_task.setImageResource(R.mipmap.lxlt_project_tab_task);
        txt_task.setTextColor(getResources().getColor(R.color.colorBlack));
        img_project.setImageResource(R.mipmap.lxlt_project_tab_project);
        txt_project.setTextColor(getResources().getColor(R.color.colorBlack));
        img_mail_list.setImageResource(R.mipmap.lxlt_project_tab_mail_list);
        txt_mail_list.setTextColor(getResources().getColor(R.color.colorBlack));
        img_mine.setImageResource(R.mipmap.lxlt_project_tab_mine_orage);
        txt_mine.setTextColor(getResources().getColor(R.color.colorOrange));
        tab_viewPager.setCurrentItem(3);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.LLayout_tabBar_task:
                showTask();
                break;
            case R.id.LLayout_tabBar_project:
                showProject();
                break;
            case R.id.LLayout_tabBar_mail_list:
                showMailList();
                break;
            case R.id.LLayout_tabBar_mine:
                showMine();
                break;
        }
    }
}
