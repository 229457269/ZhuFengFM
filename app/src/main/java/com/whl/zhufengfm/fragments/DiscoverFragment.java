package com.whl.zhufengfm.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.whl.zhufengfm.R;
import com.whl.zhufengfm.adapter.CommonFragmentPagerAdapter;
import com.whl.zhufengfm.fragments.discover.*;

import java.util.ArrayList;
import java.util.List;


public class DiscoverFragment extends Fragment implements TabLayout.OnTabSelectedListener {

    private ViewPager viewPager;

    public DiscoverFragment() {
        // Required empty public constructor

        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //
        View view = inflater.inflate(R.layout.fragment_discover, container, false);


//        //TabLayout的加载
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.discover_top_tab_bar);
//
//        TabLayout.Tab tab = tabLayout.newTab().setText("推荐");
//        tabLayout.addTab(tab);
//        TabLayout.Tab tab2 = tabLayout.newTab().setText("分类");
//        tabLayout.addTab(tab2);
//        TabLayout.Tab tab3 = tabLayout.newTab().setText("直播");
//        tabLayout.addTab(tab3);
//        TabLayout.Tab tab4 = tabLayout.newTab().setText("榜单");
//        tabLayout.addTab(tab4);
//        TabLayout.Tab tab5 = tabLayout.newTab().setText("主播");
//        tabLayout.addTab(tab5);


        //2.ViewPager的加载

        viewPager = (ViewPager) view.findViewById(R.id.discover_view_pager);
        List<BaseFragment> fragments = new ArrayList<BaseFragment>();
        fragments.add(new DisCoverRecommendFragment());
        fragments.add(new DisCoverCategoryFragment());
        fragments.add(new DisCoverLiveFragment());
        fragments.add(new DiscoverRatingFragment());
        fragments.add(new DiscoverAnchorFragment());

        CommonFragmentPagerAdapter pagerAdapter = new CommonFragmentPagerAdapter(
                getChildFragmentManager(), fragments);


        //ViewPager滑动与TabLayout绑定
        // pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

//        viewPager.setAdapter(pagerAdapter);
//
//        viewPager.addOnPageChangeListener(
//                new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        //代码添加： 封装了TabLayout 与ViewPager的联动。
        //需要  ViewPager内部指定的Adapter   必须要重写getPageTitle();
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(this);

        return view;
    }



    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }


}
