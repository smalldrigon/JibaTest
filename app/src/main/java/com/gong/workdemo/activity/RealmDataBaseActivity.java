package com.gong.workdemo.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gong.workdemo.LogCatUtil;
import com.gong.workdemo.MyApplication;
import com.gong.workdemo.R;
import com.gong.workdemo.realm.DataBaseOperationCallBack;
import com.gong.workdemo.realm.Dog;
import com.gong.workdemo.realm.RealmUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmAsyncTask;
import io.realm.RealmObject;


/**
 * Created by gong on 2018/5/15.
 */
public class RealmDataBaseActivity extends BaseAppCompatActivity {


    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.btn_querry)
    Button btnQuerry;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.tv_result)
    TextView tvResult;

    RealmAsyncTask realmAsyncTask;

    String realmVersion;

    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realm_layout);
        setTitle("Realm数据库Demo");
        LogCatUtil.i("aa", "onCreate");
        ButterKnife.bind(this);

        String ss = "1,2,3";
        LogCatUtil.i("aa", Arrays.toString(ss.split(",")));

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editText.setOnClickListener(v -> {

        });
        editText.setOnClickListener(v -> {
            LogCatUtil.i("aa","1223");
        });

        tvResult.setText(realmVersion+"==="+ MyApplication.myApplication.getmRealm().getVersion());
        tvResult.setOnClickListener(v -> {
            switch (v.getId()){

            }

        });
    }

    @OnClick({R.id.btn_add, R.id.btn_querry, R.id.btn_delete})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                List<Dog> dogs = new ArrayList<>();
                LogCatUtil.i("aa", "add");
//                TopSnackbarUtil.ShortSnackbar(view, "123", 1).show();
                for (int i =0;i<3;i++){
                    Dog dog = new Dog();
//                    dog.setId(i);
                    dog.setName("1");
                    dog.setAge(i);
                    dogs.add(dog);
                }

//                dogs.add(dog);

//                dogs.add(dog3);
                realmAsyncTask = RealmUtil.getRealmInstance().addRecord(dogs, new DataBaseOperationCallBack() {
                    @Override
                    public void Success() {
                        LogCatUtil.i("aa","插入成功");
//                        LogCatUtil.i("aa",Arrays.toString(dogs));
                    }

                    @Override
                    public void Error() {
                        LogCatUtil.i("aa","插入失败");
                    }
                });
                break;
            case R.id.btn_querry:
               List<?extends RealmObject> dogres =
                        RealmUtil.getRealmInstance().querryRecord();
//                thread.start();
                    tvResult.setText(dogres.toString());
                LogCatUtil.i("aa", "btn_querry");
                break;
            case R.id.btn_delete:

//                LogCatUtil.i("aa", "btn_delete");
                break;
        }
    }


    Thread thread = new Thread(){
        @Override
        public void run() {

//            List<Dog1>dogres = (List<Dog1>) RealmUtil.getRealmInstance().querryRecord();
//            LogCatUtil.i("aa",dogres.toString());

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
