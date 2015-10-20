package com.whl.zhufengfm;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.RadioGroup;

import com.whl.zhufengfm.fragments.CustomerTingFragment;
import com.whl.zhufengfm.fragments.DiscoverFragment;
import com.whl.zhufengfm.fragments.DownLoadTingFragment;
import com.whl.zhufengfm.fragments.PersonalFragment;


public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
//    主界面第一层Fragment发现，定制听，下载听，我
    private Fragment fragments[];

    private FragmentTransaction tx;
    private FragmentManager manager;
    int current =0 ;
    private static boolean isLoad = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            fragments = new Fragment[4];

            fragments[0]=new DiscoverFragment();
            fragments[1]=new CustomerTingFragment();
            fragments[2]=new DownLoadTingFragment();
            fragments[3]=new PersonalFragment();
        }else{
            fragments = (Fragment[]) savedInstanceState.getSerializable("fragments");
            current = savedInstanceState
                    .getInt("cur");
            isLoad = true;

            
        }
        FragmentManager manager=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction tx=manager.beginTransaction();

        int len=fragments.length;



            for (int i = 0; i < len; i++) {
                tx.add(R.id.main_fragment_container,fragments[i]);
                tx.hide(fragments[i]);
            }
            tx.commit();


        RadioGroup radioGroup= (RadioGroup) findViewById(R.id.main_tan_bar);
        radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int index=0;
        switch (checkedId){
            case R.id.main_tab_discover:
                index=0;
                break;
            case R.id.main_tab_custom:
                index=1;
                break;
            case R.id.main_tab_download:
                index=2;
                break;
            case R.id.main_tab_personal:
                index=3;
                break;
        }

        int len=fragments.length;
        FragmentManager mamger=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction tx=mamger.beginTransaction();
        for (int i = 0; i < len; i++) {
            if (i==index){
                tx.show(fragments[i]);
            }else {
                tx.hide(fragments[i]);
            }
        }
        tx.commit();
    }
}
