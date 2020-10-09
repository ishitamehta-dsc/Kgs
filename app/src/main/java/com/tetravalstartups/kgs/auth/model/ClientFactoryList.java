package com.tetravalstartups.kgs.auth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

    public class ClientFactoryList {
        @SerializedName("status")
        @Expose
        private Boolean status;
        @SerializedName("data")
        @Expose
        private List<Datum> data = null;

        /**
         * No args constructor for use in serialization
         */
        public ClientFactoryList() {
        }

        /**
         * @param data
         * @param status
         */
        public ClientFactoryList(Boolean status, List<Datum> data) {
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
            @SerializedName("group_id")
            @Expose
            private Integer groupId;
            @SerializedName("location_name")
            @Expose
            private String locationName;
            @SerializedName("address")
            @Expose
            private String address;
            @SerializedName("city")
            @Expose
            private String city;
            @SerializedName("state")
            @Expose
            private String state;
            @SerializedName("pincode")
            @Expose
            private Integer pincode;
            @SerializedName("country")
            @Expose
            private String country;
            @SerializedName("created_date")
            @Expose
            private String createdDate;
            @SerializedName("group_name")
            @Expose
            private String groupName;

            /**
             * No args constructor for use in serialization
             */
            public Datum() {
            }

            /**
             * @param pincode
             * @param country
             * @param groupName
             * @param clientId
             * @param locationName
             * @param address
             * @param createdDate
             * @param city
             * @param groupId
             * @param id
             * @param state
             */
            public Datum(Integer id, Integer clientId, Integer groupId, String locationName, String address, String city, String state, Integer pincode, String country, String createdDate, String groupName) {
                super();
                this.id = id;
                this.clientId = clientId;
                this.groupId = groupId;
                this.locationName = locationName;
                this.address = address;
                this.city = city;
                this.state = state;
                this.pincode = pincode;
                this.country = country;
                this.createdDate = createdDate;
                this.groupName = groupName;
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

            public Integer getGroupId() {
                return groupId;
            }

            public void setGroupId(Integer groupId) {
                this.groupId = groupId;
            }

            public String getLocationName() {
                return locationName;
            }

            public void setLocationName(String locationName) {
                this.locationName = locationName;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public Integer getPincode() {
                return pincode;
            }

            public void setPincode(Integer pincode) {
                this.pincode = pincode;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getCreatedDate() {
                return createdDate;
            }

            public void setCreatedDate(String createdDate) {
                this.createdDate = createdDate;
            }

            public String getGroupName() {
                return groupName;
            }

            public void setGroupName(String groupName) {
                this.groupName = groupName;
            }

        }
}
