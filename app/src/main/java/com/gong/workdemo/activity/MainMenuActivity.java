package com.gong.workdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Display;

import com.gong.workdemo.LogCatUtil;
import com.gong.workdemo.R;
import com.gong.workdemo.recycleview.BaseMainActivity;

/**所有功能案例入口
 * Created by gong on 2018/5/11.
 */

public class MainMenuActivity extends BaseMainActivity{

    private static final Class<?>[] ACTIVITY = {TopSnackBarActivity.class,RealmDataBaseActivity.class,DatabindingActivity.class,testActivity.class};
    private static final String[] TITLE = {"顶部SnackBar","realm数据库","databinding","test"};



         @Override
         public Class<?>[] getActivitys() {
        return ACTIVITY;
    }

    @Override
    public String[]
    getTitles() {
        return TITLE;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics metrics = new DisplayMetrics();
        Display display = getWindowManager().getDefaultDisplay();
        display.getMetrics(metrics);
        LogCatUtil.i("cc", "display is " + metrics.widthPixels + "*" + metrics.heightPixels);
        LogCatUtil.i("cc", "底部高度 " + getNavigationBarHeight());
        LogCatUtil.i("cc", "加载分辨率 " +getResources().getString(R.string.title));

        setTitle( metrics.widthPixels + "*" + metrics.heightPixels+"底部高度 " + getNavigationBarHeight()+"加载分辨率 " +getResources().getString(R.string.title));

    }
}
