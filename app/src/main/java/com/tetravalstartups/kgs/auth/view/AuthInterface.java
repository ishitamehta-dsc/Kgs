package com.tetravalstartups.kgs.auth.view;

import com.tetravalstartups.kgs.auth.model.CheckUser;
import com.tetravalstartups.kgs.auth.model.ClientDashboard;
import com.tetravalstartups.kgs.auth.model.ClientFactoryList;
import com.tetravalstartups.kgs.auth.model.ClientInvoiceList;
import com.tetravalstartups.kgs.auth.model.ClientMedia;
import com.tetravalstartups.kgs.auth.model.ClientNotification;
import com.tetravalstartups.kgs.auth.model.ClientProfileDetail;
import com.tetravalstartups.kgs.auth.model.ClientSubscriptionList;
import com.tetravalstartups.kgs.auth.model.StaffProfileDetail;

import java.util.List;

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

    @FormUrlEncoded
    @POST("auth/NotificationList")
    Call<ClientNotification> clientNotification(@Field("client_id") int client_id);

    @FormUrlEncoded
    @POST("auth/ClientProfileDetail")
    Call<ClientProfileDetail> clientProfileDetail(@Field("client_id") int client_id);

    @FormUrlEncoded
    @POST("auth/StaffProfileDetail")
    Call<StaffProfileDetail> staffProfileDetail(@Field("staff_id") int staff_id);

    @FormUrlEncoded
    @POST("auth/FactoryList")
    Call<ClientFactoryList> clientFactory(@Field("client_id") int client_id);

    @FormUrlEncoded
    @POST("auth/ClientMedia")
    Call<List<ClientMedia>> clientMedia(@Field("client_id") int client_id);

    @FormUrlEncoded
    @POST("auth/invoiceList")
    Call<ClientInvoiceList> clientInvoice(@Field("client_id") int client_id);

    @FormUrlEncoded
    @POST("auth/subscriptionList")
    Call<ClientSubscriptionList> clientSubscription(@Field("client_id") int client_id);

}
