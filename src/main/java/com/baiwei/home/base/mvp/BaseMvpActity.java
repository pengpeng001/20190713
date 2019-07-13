package com.baiwei.home.base.mvp;

import com.baiwei.home.base.BaseActity;

public abstract class BaseMvpActity <P extends BasePresenter , M extends BaseModel> extends BaseActity implements BaseView {

    public P presenter;
    public M model;

    @Override
    protected int initViewId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initDate() {
        presenter = (P) initPresenter();
        if (presenter != null){
            model = (M) presenter.getModel();
            if (model != null){
                presenter.arrt(this , model);
            }
        }
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
