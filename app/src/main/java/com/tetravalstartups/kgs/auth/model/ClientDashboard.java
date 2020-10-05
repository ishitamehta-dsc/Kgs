package com.tetravalstartups.kgs.auth.model;

import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClientDashboard {

@SerializedName("status")
@Expose
private Boolean status;
@SerializedName("data")
@Expose

private Data data;

/**
* No args constructor for use in serialization
*
*/
public ClientDashboard() {
}

/**
*
* @param data
* @param status
*/
public ClientDashboard(Boolean status, Data data) {
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

public Data getData() {
return data;
}

public void setData(Data data) {
this.data = data;
}

    public class Data {

        @SerializedName("subscription")
        @Expose
        private Subscription subscription;
        @SerializedName("notification")
        @Expose
        private List<Notification> notification = null;

        /**
         * No args constructor for use in serialization
         *
         */
        public Data() {
        }

        /**
         *
         * @param notification
         * @param subscription
         */
        public Data(Subscription subscription, List<Notification> notification) {
            super();
            this.subscription = subscription;
            this.notification = notification;
        }

        public Subscription getSubscription() {
            return subscription;
        }

        public void setSubscription(Subscription subscription) {
            this.subscription = subscription;
        }

        public List<Notification> getNotification() {
            return notification;
        }

        public void setNotification(List<Notification> notification) {
            this.notification = notification;
        }

    }

    public class Notification {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("type")
        @Expose
        private Integer type;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("created_date")
        @Expose
        private String createdDate;
        @SerializedName("notic_for")
        @Expose
        private Integer noticFor;

        /**
         * No args constructor for use in serialization
         *
         */
        public Notification() {
        }

        /**
         *
         * @param noticFor
         * @param createdDate
         * @param description
         * @param id
         * @param type
         * @param userId
         */
        public Notification(Integer id, Integer userId, Integer type, String description, String createdDate, Integer noticFor) {
            super();
            this.id = id;
            this.userId = userId;
            this.type = type;
            this.description = description;
            this.createdDate = createdDate;
            this.noticFor = noticFor;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public Integer getNoticFor() {
            return noticFor;
        }

        public void setNoticFor(Integer noticFor) {
            this.noticFor = noticFor;
        }

    }

    public class Subscription {

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
        private Integer totalAmount;
        @SerializedName("paid")
        @Expose
        private Integer paid;
        @SerializedName("pending_payment")
        @Expose
        private Integer pendingPayment;
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
        public Subscription() {
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
        public Subscription(Integer id, Integer clientId, String subStartDate, String subEndDate, Integer paymentType, Integer totalAmount, Integer paid, Integer pendingPayment, Integer status, String timestamp) {
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

        public Integer getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(Integer totalAmount) {
            this.totalAmount = totalAmount;
        }

        public Integer getPaid() {
            return paid;
        }

        public void setPaid(Integer paid) {
            this.paid = paid;
        }

        public Integer getPendingPayment() {
            return pendingPayment;
        }

        public void setPendingPayment(Integer pendingPayment) {
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