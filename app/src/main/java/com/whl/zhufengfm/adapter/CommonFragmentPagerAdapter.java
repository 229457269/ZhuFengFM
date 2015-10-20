package com.whl.zhufengfm.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.whl.zhufengfm.fragments.BaseFragment;

import java.util.List;

/**
 * Project_name : ZhuFengFM
 * Author : zhaoQiang
 * Email : 229457269@qq.com
 * Create_time : 2015/10/20 | 10:50
 */
public class CommonFragmentPagerAdapter extends FragmentPagerAdapter{

    private List<BaseFragment> fragments;

    public CommonFragmentPagerAdapter(FragmentManager fm,List<BaseFragment> fragments) {
        super(fm);
        this.fragments =  fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        int ret = 0;
        if(fragments!=null){
            ret = fragments.size();
        }
        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        String ret = null;

        BaseFragment baseFragment = fragments.get(position);
        ret = baseFragment.getFragmentTitle();
        return ret;

    }


}
