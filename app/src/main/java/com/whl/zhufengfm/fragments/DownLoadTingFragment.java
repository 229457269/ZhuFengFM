package com.whl.zhufengfm.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whl.zhufengfm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DownLoadTingFragment extends android.support.v4.app.Fragment {


    public DownLoadTingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover_live, container, false);
    }


}
