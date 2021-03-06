package com.tetravalstartups.kgs.auth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tetravalstartups.kgs.client.model.ClientDashResponse;

import java.util.List;

public class ClientDashboard {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose

    private ClientDashResponse data;

    /**
     * No args constructor for use in serialization
     */
    public ClientDashboard() {
    }

    /**
     * @param data
     * @param status
     */
    public ClientDashboard(Boolean status, ClientDashResponse data) {
        super();
        this.status = status;
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ClientDashResponse getData() {
        return data;
    }

    public void setData(ClientDashResponse data) {
        this.data = data;
    }


}