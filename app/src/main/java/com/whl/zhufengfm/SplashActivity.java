package com.whl.zhufengfm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

/*
* 启动扉页
* */
public class SplashActivity extends FragmentActivity implements Runnable {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent();
//        TODO 如果没有显示页那么启动欢迎页，否则直接启动首页
        SharedPreferences sp = getSharedPreferences(Constants.SP_NAME, MODE_PRIVATE);
//        利用sp保存字段，判断是否显示欢迎页，保存的数值一定是程序版本号，利用当前程序版本号和sp中的版本号比较
//        这样更精确，兼容性好
//        当前程序的版本号
        int wsv = sp.getInt(Constants.SP_KEY_WELCOME_SHOW_VER, -1);
//
        if (BuildConfig.VERSION_CODE != wsv) {
//            TODO 显示欢迎页
        intent.setClass(this,WelcomeActivity.class);

        } else {
//            TODO 显示主界面
            intent.setClass(this,MainActivity.class);
        }
        startActivity(intent);
        finish();

    }

}
