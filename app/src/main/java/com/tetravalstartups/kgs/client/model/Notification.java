package com.tetravalstartups.kgs.client.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
         */
        public Notification() {
        }

        /**
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