package com.tetravalstartups.kgs.client.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientSubscriptionResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("client_id")
    @Expose
    private Integer clientId;
    @SerializedName("subscription_id")
    @Expose
    private Integer subscriptionId;
    @SerializedName("invoice_id")
    @Expose
    private Integer invoiceId;
    @SerializedName("subscription_paid_amount")
    @Expose
    private Integer subscriptionPaidAmount;
    @SerializedName("billing_amount")
    @Expose
    private Integer billingAmount;
    @SerializedName("discount")
    @Expose
    private Integer discount;
    @SerializedName("balance_due")
    @Expose
    private Integer balanceDue;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("invoice_date")
    @Expose
    private String invoiceDate;
    @SerializedName("created_date")
    @Expose
    private String createdDate;

    /**
     * No args constructor for use in serialization
     */
    public ClientSubscriptionResponse() {
    }

    /**
     * @param clientId
     * @param billingAmount
     * @param createdDate
     * @param balanceDue
     * @param discount
     * @param invoiceId
     * @param id
     * @param subscriptionId
     * @param invoiceDate
     * @param subscriptionPaidAmount
     * @param status
     */
    public ClientSubscriptionResponse(Integer id, Integer clientId, Integer subscriptionId, Integer invoiceId, Integer subscriptionPaidAmount, Integer billingAmount, Integer discount, Integer balanceDue, Integer status, String invoiceDate, String createdDate) {
        super();
        this.id = id;
        this.clientId = clientId;
        this.subscriptionId = subscriptionId;
        this.invoiceId = invoiceId;
        this.subscriptionPaidAmount = subscriptionPaidAmount;
        this.billingAmount = billingAmount;
        this.discount = discount;
        this.balanceDue = balanceDue;
        this.status = status;
        this.invoiceDate = invoiceDate;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getSubscriptionPaidAmount() {
        return subscriptionPaidAmount;
    }

    public void setSubscriptionPaidAmount(Integer subscriptionPaidAmount) {
        this.subscriptionPaidAmount = subscriptionPaidAmount;
    }

    public Integer getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(Integer billingAmount) {
        this.billingAmount = billingAmount;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getBalanceDue() {
        return balanceDue;
    }

    public void setBalanceDue(Integer balanceDue) {
        this.balanceDue = balanceDue;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

}