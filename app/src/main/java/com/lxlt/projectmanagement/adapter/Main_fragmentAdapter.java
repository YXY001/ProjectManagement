package com.lxlt.projectmanagement.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 苑雪元 on 2016/6/4.
 */
public class Main_fragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list_fragment;
    public Main_fragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        list_fragment = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_fragment.size();
    }
}
