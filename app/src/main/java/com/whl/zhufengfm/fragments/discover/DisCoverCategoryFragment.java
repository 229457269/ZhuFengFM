package com.whl.zhufengfm.fragments.discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.whl.zhufengfm.R;
import com.whl.zhufengfm.entity.DiscoverCategroy;
import com.whl.zhufengfm.fragments.BaseFragment;
import com.whl.zhufengfm.tasks.DiscoverCategoryTAsk;

/**
 * Project_name : ZhuFengFM
 * Author : zhaoQiang
 * Email : 229457269@qq.com
 * Create_time : 2015/10/20 | 10:57
 */
public class DisCoverCategoryFragment extends BaseFragment{

    public DisCoverCategoryFragment() {
    }

    @Override
    public String getFragmentTitle() {
        return "分类";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        DiscoverCategoryTAsk task = new DiscoverCategoryTAsk();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discover_category, container,false);
    }

    ontaskFinished

}
