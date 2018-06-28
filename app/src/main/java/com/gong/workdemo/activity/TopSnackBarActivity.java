package com.gong.workdemo.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.gong.workdemo.LogCatUtil;
import com.gong.workdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import top_snackbar.BaseTransientBottomBar;
import top_snackbar.TopSnackBar;
import top_snackbar.TopSnackbarUtil;


/**
 * 需要依赖 com.android.support:design
 * 需要 design_layout_top_snackbar.xml  and  design_layout_top_snackbar_include.xml
 *
 * @version : v1.0
 * @project : TopSnackbar_demo
 * @Email : dakun611@Gmail.com
 */

public class TopSnackBarActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.coor)
    CoordinatorLayout coor;

    @BindView(R.id.linea)
    LinearLayout linea;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        findViewById(R.id.show_top_snack_bar).setOnClickListener(this);
        findViewById(R.id.show_snack_bar).setOnClickListener(this);
        setTitle("TopSnackBarActivity"+getResources().getString(R.string.title));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_top_snack_bar:
//
                //自定义view 的实例
                TopSnackbarUtil.LongSnackbarWithConform(v, "妹子删了你发出的消息", TopSnackbarUtil.Warning)
                        .setActionTextColor(Color.RED).setAction("再次发送", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

//                        TopSnackbarUtil.LongSnackbar(v, "妹子已将你拉黑", TopSnackbarUtil.Alert)
//                                .setActionTextColor(Color.WHITE).show();
                    }
                }).show();

//                TopSnackbarUtil.SnackbarAddView(snackbar, R.layout.snackbar_addview, 0);
//
//                TopSnackbarUtil.SnackbarAddView(snackbar, R.layout.snackbar_addview2, 2);

//                snackbar.show();


                break;
            case R.id.show_snack_bar:
                Snackbar.make(coor, "我是源版SnackBar", BaseTransientBottomBar.LENGTH_SHORT).show();
                TopSnackbarUtil.ShortSnackbar(v, "妹子向你发来一条消息", TopSnackbarUtil.Info).show();

                    addSharepreference("int",9);
                    LogCatUtil.i("aa",getSharepreference("int",1).getClass().getSimpleName()+"");
                    addSharepreference("float",2f);
                    LogCatUtil.i("aa",getSharepreference("float",1f).getClass().getSimpleName()+"");
                    addSharepreference("String","String");
                    LogCatUtil.i("aa",getSharepreference("String","String").getClass().getSimpleName()+"");
                    addSharepreference("Long",3L);
                    LogCatUtil.i("aa",getSharepreference("Long",1l).getClass().getSimpleName()+"");
                    addSharepreference("Boolean",true);
                    LogCatUtil.i("aa",getSharepreference("Boolean",false).getClass().getSimpleName()+"");
//

                break;



        }
    }



    public void addSharepreference(String name, Object value) {
        SharedPreferences sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        switch (getType(value)){
            case  "Integer":
                sp.edit().putInt(name, (int)value).commit();

                break;

            case  "Float":
                sp.edit().putFloat(name,(Float)value ).commit();

                break;
            case  "String":
                sp.edit().putString(name, String.valueOf(value)).commit();

                break;
            case  "Long":
                sp.edit().putLong(name, (Long)value).commit();

                break;
            case  "Boolean":
                sp.edit().putBoolean(name, (Boolean)value).commit();

                break;
        }

    }
    public   <T> T getSharepreference(String name,T defaultvalue) {
        SharedPreferences sp =getSharedPreferences("userInfo", Context.MODE_PRIVATE);
            T tt = null;
        Class<T> clazz =null;
        Object value = null;
        switch (getType(defaultvalue)){
            case  "Integer":
                value = sp.getInt(name, (Integer) defaultvalue);
                 clazz=(Class<T>) defaultvalue.getClass();
                if(clazz!=null){
                     tt = clazz.cast(value);

                }

                break;

            case  "Float":

                value = sp.getFloat(name, (Float) defaultvalue);
                clazz=(Class<T>) defaultvalue.getClass();
                if(clazz!=null){
                    tt = clazz.cast(value);

                }

                break;
            case  "String":
                value = sp.getString(name, (String) defaultvalue);
                clazz=(Class<T>) defaultvalue.getClass();
                if(clazz!=null){
                    tt = clazz.cast(value);

                }

                break;
            case  "Long":
                value = sp.getLong(name, (Long) defaultvalue);
                clazz=(Class<T>) defaultvalue.getClass();
                if(clazz!=null){
                    tt = clazz.cast(value);

                }
                break;
            case  "Boolean":
                value = sp.getBoolean(name, (Boolean) defaultvalue);
                clazz=(Class<T>) defaultvalue.getClass();
                if(clazz!=null){
                    tt = clazz.cast(value);

                }
                     break;
        }

        return tt;
    }
    public  String getType(Object o){ //获取变量类型方法

        String str = o.getClass().getSimpleName(); //使用int类型的getClass()方法

        return str;}

}
