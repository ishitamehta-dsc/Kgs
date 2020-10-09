package com.tetravalstartups.kgs.auth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClientSubscriptionList {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ClientSubscriptionList() {
    }

    /**
     *
     * @param data
     * @param status
     */
    public ClientSubscriptionList(Boolean status, List<Datum> data) {
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

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("client_id")
        @Expose
        private Integer clientId;
        @SerializedName("sub_start_date")
        @Expose
        private String subStartDate;
        @SerializedName("sub_end_date")
        @Expose
        private String subEndDate;
        @SerializedName("payment_type")
        @Expose
        private Integer paymentType;
        @SerializedName("total_amount")
        @Expose
        private String totalAmount;
        @SerializedName("paid")
        @Expose
        private String paid;
        @SerializedName("pending_payment")
        @Expose
        private String pendingPayment;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("timestamp")
        @Expose
        private String timestamp;

        /**
         * No args constructor for use in serialization
         *
         */
        public Datum() {
        }

        /**
         *
         * @param subStartDate
         * @param totalAmount
         * @param clientId
         * @param subEndDate
         * @param pendingPayment
         * @param paid
         * @param id
         * @param paymentType
         * @param status
         * @param timestamp
         */
        public Datum(Integer id, Integer clientId, String subStartDate, String subEndDate, Integer paymentType, String totalAmount, String paid, String pendingPayment, Integer status, String timestamp) {
            super();
            this.id = id;
            this.clientId = clientId;
            this.subStartDate = subStartDate;
            this.subEndDate = subEndDate;
            this.paymentType = paymentType;
            this.totalAmount = totalAmount;
            this.paid = paid;
            this.pendingPayment = pendingPayment;
            this.status = status;
            this.timestamp = timestamp;
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

        public String getSubStartDate() {
            return subStartDate;
        }

        public void setSubStartDate(String subStartDate) {
            this.subStartDate = subStartDate;
        }

        public String getSubEndDate() {
            return subEndDate;
        }

        public void setSubEndDate(String subEndDate) {
            this.subEndDate = subEndDate;
        }

        public Integer getPaymentType() {
            return paymentType;
        }

        public void setPaymentType(Integer paymentType) {
            this.paymentType = paymentType;
        }

        public String getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getPaid() {
            return paid;
        }

        public void setPaid(String paid) {
            this.paid = paid;
        }

        public String getPendingPayment() {
            return pendingPayment;
        }

        public void setPendingPayment(String pendingPayment) {
            this.pendingPayment = pendingPayment;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

    }
}
