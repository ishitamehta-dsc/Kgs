package com.tetravalstartups.kgs.auth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tetravalstartups.kgs.client.model.ClientSubscriptionResponse;

import java.util.IntSummaryStatistics;

public class ClientInvoiceList {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private ClientSubscriptionResponse data;

    /**
     * No args constructor for use in serialization
     *
     */
    public ClientInvoiceList() {
    }

    /**
     *
     * @param data
     * @param status
     */
    public ClientInvoiceList(Boolean status, ClientSubscriptionResponse data) {
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

    public ClientSubscriptionResponse getData() {
        return data;
    }

    public void setData(ClientSubscriptionResponse data) {
        this.data = data;
    }
}
