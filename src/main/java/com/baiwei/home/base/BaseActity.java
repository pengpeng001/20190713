package com.baiwei.home.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.baiwei.home.base.mvp.BaseModel;
import com.baiwei.home.base.mvp.BasePresenter;
import com.baiwei.home.base.mvp.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActity <P extends BasePresenter, M extends BaseModel> extends AppCompatActivity implements BaseView {
    private boolean isimersionbar;//沉浸式

    private Unbinder unbinder;


    private P presenter;
    private M model;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initViewId());
        unbinder = ButterKnife.bind(this);

        initView();
        init();
        initDate();

    }

    private void init() {


        presenter = (P) initPresenter();

        if (presenter != null){
            model = (M) presenter.getModel();
            if (model != null){
                presenter.arrt(this , model);
            }
        }
    }

    protected abstract int initViewId();

    protected abstract void initView();

    protected abstract void initDate();

    /**
     * 无参跳转
     * @param cla
     */
    public void startActity(Class<?> cla){
        startActivity(new Intent(this , cla));
    }
    /**
     * 有参跳转
     * @param cla
     */
    public void startActity(Class<?> cla , Bundle bundle){
        Intent intent = new Intent(this, cla);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 沉浸式
     * @param isimersionbar
     */
    public void isImerSineBar(boolean isimersionbar){
        if (isimersionbar){

        }
    }

    /**
     * Tost吐司
     * @param msg
     */
    public void showToast(String msg){
        Toast.makeText(this , msg , Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null){
            unbinder.unbind();
        }
        if (presenter !=null){
            presenter.detach();
        }

    }
}
