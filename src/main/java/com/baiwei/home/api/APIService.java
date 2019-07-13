package com.baiwei.home.api;

import com.baiwei.home.entity.UserEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @POST
    @FormUrlEncoded
    Observable<UserEntity> login(@FieldMap HashMap<String , String > hashMap);



}
