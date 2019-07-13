package com.baiwei.home.actity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baiwei.home.R;
import com.baiwei.home.api.APIService;
import com.baiwei.home.base.BaseActity;
import com.baiwei.home.base.mvp.BasePresenter;
import com.baiwei.home.base.net.RetrFigManager;
import com.baiwei.home.entity.UserEntity;
import com.baiwei.home.model.Model;
import com.baiwei.home.presenter.Presenter;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends BaseActity<Presenter ,Model> {

    @Override
    protected int initViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initDate() {

    }

    @Override
    public BasePresenter initPresenter() {
        BasePresenter basePresenter = initPresenter();
        basePresenter.arrt(this , );
        basePresenter.

        return null;
    }

    @Override
    public void onFaile(String msg) {

    }

    @Override
    public void onshowLoding() {

    }

    @Override
    public void onhideLoding() {

    }
}
