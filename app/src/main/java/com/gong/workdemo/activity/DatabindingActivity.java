package com.gong.workdemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;


import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gong.workdemo.LogCatUtil;
import com.gong.workdemo.R;

import com.gong.workdemo.bean.TitleModul;


import com.gong.workdemo.databinding.TestDatabindBinding;
import com.gong.workdemo.interfases.TitleClick;


public class DatabindingActivity extends AppCompatActivity implements TitleClick{

    TitleModul title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//         binding =
        TestDatabindBinding binding= DataBindingUtil.setContentView(this,R.layout.test_databind);
//
          title = new TitleModul(false,"测试标题",false,"123");
//
//        title.setTitle("gafsdas");
        binding.setTitle(title);
        binding.setHandlers(this);


//   TestDatabindBinding  DataBindingUtil.setContentView(this,R.layout.test_databind);

    }

//    TitleClick click = new TitleClick() {

        @Override
        public void goBackClick(View view,int a,String s) {
            LogCatUtil.i("aa","点了返回"+a+s);
           new Mythread().start();
        }

        @Override
        public void rightTitleClick(View view,int a,String s) {
            LogCatUtil.i("aa","点了右边"+a+s);
        }
//    };



    class  Mythread extends Thread{
        @Override
        public void run() {

            title.setShowRight(true);
            title.setTitle(System.currentTimeMillis()+"");

        }
    }

}
