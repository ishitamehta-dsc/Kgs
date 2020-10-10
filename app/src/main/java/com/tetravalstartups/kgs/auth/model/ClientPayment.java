package com.tetravalstartups.kgs.auth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ClientPayment {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("paid_amount")
    @Expose
    private String paidAmount;
    @SerializedName("pending_amount")
    @Expose
    private String pendingAmount;

    /**
     * No args constructor for use in serialization
     *
     */
    public ClientPayment() {
    }

    /**
     *
     * @param paidAmount
     * @param pendingAmount
     * @param status
     */
    public ClientPayment(Boolean status, String paidAmount, String pendingAmount) {
        super();
        this.status = status;
        this.paidAmount = paidAmount;
        this.pendingAmount = pendingAmount;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(String pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

}
