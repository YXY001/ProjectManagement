package com.lxlt.projectmanagement.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxlt.projectmanagement.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyChargeFragment extends Fragment {


    public MyChargeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_charge, container, false);
    }

}
