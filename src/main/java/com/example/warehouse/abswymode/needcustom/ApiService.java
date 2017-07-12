package com.example.warehouse.abswymode.needcustom;


import com.example.warehouse.abswymode.bean.UserEntity;

import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by helin on 2016/10/9 17:09.
 */

public interface ApiService {
    @GET("/student/mobileRegister")
    Observable<HttpResult<UserEntity>> login(@Query("phone") String phone, @Query("password") String psw);

    @POST()
    Observable<HttpResult<Object>> post(@Field("sss")String sss);

}
