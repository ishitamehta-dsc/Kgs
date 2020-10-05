package com.tetravalstartups.kgs.auth.view;

import com.tetravalstartups.kgs.auth.model.CheckUser;
import com.tetravalstartups.kgs.auth.model.ClientDashboard;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthInterface {

    @FormUrlEncoded
    @POST("auth/CheckUser")
    Call<CheckUser> checkUser(@Field("phone") String phone);


    @FormUrlEncoded
    @POST("auth/ClientDashboard")
    Call<ClientDashboard> clientDashboard(@Field("client_id") int client_id);




}
