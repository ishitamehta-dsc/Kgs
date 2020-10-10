package com.tetravalstartups.kgs.auth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientProfileDetail {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * No args constructor for use in serialization
     *
     */
    public ClientProfileDetail() {
    }

    /**
     *
     * @param data
     * @param type
     * @param status
     */
    public ClientProfileDetail(Boolean status, Integer type, Data data) {
        super();
        this.status = status;
        this.type = type;
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("fname")
        @Expose
        private String fname;
        @SerializedName("lname")
        @Expose
        private String lname;
        @SerializedName("mobile_1")
        @Expose
        private String mobile1;
        @SerializedName("mobile_2")
        @Expose
        private String mobile2;
        @SerializedName("email_1")
        @Expose
        private String email1;
        @SerializedName("email_2")
        @Expose
        private String email2;
        @SerializedName("company_name")
        @Expose
        private String companyName;
        @SerializedName("profile_image")
        @Expose
        private String profileImage;
        @SerializedName("gst")
        @Expose
        private Integer gst;
        @SerializedName("gst_number")
        @Expose
        private String gstNumber;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("created_date")
        @Expose
        private String createdDate;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("pending_update_request")
        @Expose
        private Integer pendingUpdateRequest;

        /**
         * No args constructor for use in serialization
         *
         */
        public Data() {
        }

        /**
         *
         * @param fname
         * @param address
         * @param pendingUpdateRequest
         * @param companyName
         * @param mobile1
         * @param gst
         * @param profileImage
         * @param email2
         * @param gstNumber
         * @param lname
         * @param email1
         * @param createdDate
         * @param mobile2
         * @param id
         * @param status
         */
        public Data(Integer id, String fname, String lname, String mobile1, String mobile2, String email1, String email2, String companyName, String profileImage, Integer gst, String gstNumber, Integer status, String createdDate, String address, Integer pendingUpdateRequest) {
            super();
            this.id = id;
            this.fname = fname;
            this.lname = lname;
            this.mobile1 = mobile1;
            this.mobile2 = mobile2;
            this.email1 = email1;
            this.email2 = email2;
            this.companyName = companyName;
            this.profileImage = profileImage;
            this.gst = gst;
            this.gstNumber = gstNumber;
            this.status = status;
            this.createdDate = createdDate;
            this.address = address;
            this.pendingUpdateRequest = pendingUpdateRequest;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getLname() {
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        public String getMobile1() {
            return mobile1;
        }

        public void setMobile1(String mobile1) {
            this.mobile1 = mobile1;
        }

        public String getMobile2() {
            return mobile2;
        }

        public void setMobile2(String mobile2) {
            this.mobile2 = mobile2;
        }

        public String getEmail1() {
            return email1;
        }

        public void setEmail1(String email1) {
            this.email1 = email1;
        }

        public String getEmail2() {
            return email2;
        }

        public void setEmail2(String email2) {
            this.email2 = email2;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public int getProfileImage() {
            return Integer.parseInt(profileImage);
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

        public Integer getGst() {
            return gst;
        }

        public void setGst(Integer gst) {
            this.gst = gst;
        }

        public String getGstNumber() {
            return gstNumber;
        }

        public void setGstNumber(String gstNumber) {
            this.gstNumber = gstNumber;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Integer getPendingUpdateRequest() {
            return pendingUpdateRequest;
        }

        public void setPendingUpdateRequest(Integer pendingUpdateRequest) {
            this.pendingUpdateRequest = pendingUpdateRequest;
        }

    }

}
