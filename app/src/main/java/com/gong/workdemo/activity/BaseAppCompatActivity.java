package com.gong.workdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;


import butterknife.ButterKnife;

//import butterknife.ButterKnife;

/**
 * Created by gong on 2018/5/16.
 */
public class BaseAppCompatActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(null);
//        ButterKnife.bind(this);
    }
}
