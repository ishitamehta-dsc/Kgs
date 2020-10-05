package com.tetravalstartups.kgs.auth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckUser {

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
     */
    public CheckUser() {
    }

    /**
     * @param data
     * @param type
     * @param status
     */
    public CheckUser(Boolean status, Integer type, Data data) {
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
        @SerializedName("sector")
        @Expose
        private String sector;
        @SerializedName("adv_payment")
        @Expose
        private String advPayment;
        @SerializedName("pending_payment")
        @Expose
        private String pendingPayment;
        @SerializedName("profile_image")
        @Expose
        private String profileImage;
        @SerializedName("gst")
        @Expose
        private String gst;
        @SerializedName("gst_number")
        @Expose
        private String gstNumber;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("created_date")
        @Expose
        private String createdDate;

        /**
         * No args constructor for use in serialization
         */
        public Data() {
        }

        /**
         * @param fname
         * @param companyName
         * @param mobile1
         * @param gst
         * @param profileImage
         * @param email2
         * @param gstNumber
         * @param lname
         * @param email1
         * @param createdDate
         * @param pendingPayment
         * @param mobile2
         * @param id
         * @param sector
         * @param advPayment
         * @param status
         */
        public Data(Integer id, String fname, String lname, String mobile1, String mobile2, String email1, String email2, String companyName, String sector, String advPayment, String pendingPayment, String profileImage, String gst, String gstNumber, String status, String createdDate) {
            super();
            this.id = id;
            this.fname = fname;
            this.lname = lname;
            this.mobile1 = mobile1;
            this.mobile2 = mobile2;
            this.email1 = email1;
            this.email2 = email2;
            this.companyName = companyName;
            this.sector = sector;
            this.advPayment = advPayment;
            this.pendingPayment = pendingPayment;
            this.profileImage = profileImage;
            this.gst = gst;
            this.gstNumber = gstNumber;
            this.status = status;
            this.createdDate = createdDate;
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

        public String getSector() {
            return sector;
        }

        public void setSector(String sector) {
            this.sector = sector;
        }

        public String getAdvPayment() {
            return advPayment;
        }

        public void setAdvPayment(String advPayment) {
            this.advPayment = advPayment;
        }

        public String getPendingPayment() {
            return pendingPayment;
        }

        public void setPendingPayment(String pendingPayment) {
            this.pendingPayment = pendingPayment;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

        public String getGst() {
            return gst;
        }

        public void setGst(String gst) {
            this.gst = gst;
        }

        public String getGstNumber() {
            return gstNumber;
        }

        public void setGstNumber(String gstNumber) {
            this.gstNumber = gstNumber;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

    }

}


