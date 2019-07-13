package com.baiwei.home.base.mvp;

public interface BaseView {
    BasePresenter initPresenter();
    void onFaile(String msg);

    void onshowLoding();

    void onhideLoding();

}
