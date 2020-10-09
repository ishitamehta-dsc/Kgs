package com.tetravalstartups.kgs.client.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClientDashResponse {

        @SerializedName("notification")
        @Expose
        private List<Notification> notification = null;
        /**
         * No args constructor for use in serialization
         */
        public ClientDashResponse() {
        }

        /**
         * @param notification
         */
        public ClientDashResponse(List<Notification> notification) {
            super();
            this.notification = notification;
        }


        public List<Notification> getNotification() {
            return notification;
        }

        public void setNotification(List<Notification> notification) {
            this.notification = notification;
        }

    }
