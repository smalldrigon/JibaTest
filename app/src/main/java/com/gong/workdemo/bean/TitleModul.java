package com.gong.workdemo.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.gong.workdemo.BR;

public class TitleModul extends BaseObservable{
    private  boolean isShowLeftBack;
    private String title;
    private boolean isShowRight;

    public TitleModul(boolean isShowLeftBack, String title, boolean isShowRight, String titleRigh) {
        this.isShowLeftBack = isShowLeftBack;
        this.title = title;
        this.isShowRight = isShowRight;
        this.titleRigh = titleRigh;
    }
@Bindable
    public boolean isShowRight() {
        return isShowRight;
    }

    public void setShowRight(boolean showRight) {
        isShowRight = showRight;
        notifyPropertyChanged(BR.showRight);
    }

    private String titleRigh;

    public boolean isShowLeftBack() {
        return isShowLeftBack;
    }

    public void setShowLeftBack(boolean showLeftBack) {
        isShowLeftBack = showLeftBack;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }




    public String getTitleRigh() {
        return titleRigh;
    }

    public void setTitleRigh(String titleRigh) {
        this.titleRigh = titleRigh;
    }
}
