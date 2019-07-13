package com.baiwei.home.base.mvp;

import java.lang.ref.WeakReference;
import java.util.HashMap;

public abstract class BasePresenter<V , M> {

    public V view;

    public M model;

    public abstract M getModel();

    public WeakReference <V> vWeakReference;

    public void arrt(V view , M  model){
        this.model = model;
        vWeakReference = new WeakReference<>(view);
        this.view = vWeakReference.get();
    }
    public void detach(){
        if (vWeakReference != null){
            vWeakReference.clear();
            vWeakReference = null;
            view = null;
        }
    }





}
