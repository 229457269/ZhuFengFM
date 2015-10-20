package com.whl.zhufengfm.fragments.discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.whl.zhufengfm.R;
import com.whl.zhufengfm.fragments.BaseFragment;

/**
 * Project_name : ZhuFengFM
 * Author : zhaoQiang
 * Email : 229457269@qq.com
 * Create_time : 2015/10/20 | 10:57
 */
public class DiscoverRatingFragment extends BaseFragment{

    public DiscoverRatingFragment() {
    }

    @Override
    public String getFragmentTitle() {
        return "榜单";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover_rating, container, false);
    }

}
