package com.tetravalstartups.kgs.auth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientMediaResponse {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("staff_id")
        @Expose
        private Integer staffId;
        @SerializedName("factory_id")
        @Expose
        private Integer factoryId;
        @SerializedName("group_id")
        @Expose
        private Integer groupId;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("upload_date")
        @Expose
        private String uploadDate;
        @SerializedName("client_id")
        @Expose
        private Integer clientId;
        @SerializedName("shift")
        @Expose
        private Integer shift;
        @SerializedName("upload_type")
        @Expose
        private Integer uploadType;
        @SerializedName("group_name")
        @Expose
        private String groupName;
        @SerializedName("factory_name")
        @Expose
        private String factoryName;
        @SerializedName("media")
        @Expose
        private String media;

        /**
         * No args constructor for use in serialization
         *
         */
        public ClientMediaResponse() {
        }

        /**
         *
         * @param groupName
         * @param clientId
         * @param uploadDate
         * @param factoryId
         * @param groupId
         * @param shift
         * @param uploadType
         * @param description
         * @param factoryName
         * @param id
         * @param media
         * @param staffId
         */
        public ClientMediaResponse(Integer id, Integer staffId, Integer factoryId, Integer groupId, String description, String uploadDate, Integer clientId, Integer shift, Integer uploadType, String groupName, String factoryName, String media) {
            super();
            this.id = id;
            this.staffId = staffId;
            this.factoryId = factoryId;
            this.groupId = groupId;
            this.description = description;
            this.uploadDate = uploadDate;
            this.clientId = clientId;
            this.shift = shift;
            this.uploadType = uploadType;
            this.groupName = groupName;
            this.factoryName = factoryName;
            this.media = media;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getStaffId() {
            return staffId;
        }

        public void setStaffId(Integer staffId) {
            this.staffId = staffId;
        }

        public Integer getFactoryId() {
            return factoryId;
        }

        public void setFactoryId(Integer factoryId) {
            this.factoryId = factoryId;
        }

        public Integer getGroupId() {
            return groupId;
        }

        public void setGroupId(Integer groupId) {
            this.groupId = groupId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUploadDate() {
            return uploadDate;
        }

        public void setUploadDate(String uploadDate) {
            this.uploadDate = uploadDate;
        }

        public Integer getClientId() {
            return clientId;
        }

        public void setClientId(Integer clientId) {
            this.clientId = clientId;
        }

        public Integer getShift() {
            return shift;
        }

        public void setShift(Integer shift) {
            this.shift = shift;
        }

        public Integer getUploadType() {
            return uploadType;
        }

        public void setUploadType(Integer uploadType) {
            this.uploadType = uploadType;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public String getFactoryName() {
            return factoryName;
        }

        public void setFactoryName(String factoryName) {
            this.factoryName = factoryName;
        }

        public String getMedia() {
            return media;
        }

        public void setMedia(String media) {
            this.media = media;
        }

    }