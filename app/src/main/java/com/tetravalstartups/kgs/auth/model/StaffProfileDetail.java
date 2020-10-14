package com.tetravalstartups.kgs.auth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StaffProfileDetail {

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
    public StaffProfileDetail() {
    }

    /**
     *
     * @param data
     * @param status
     */
    public StaffProfileDetail(Boolean status, Data data) {
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

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("fname")
        @Expose
        private String fname;
        @SerializedName("lname")
        @Expose
        private String lname;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("mobile_1")
        @Expose
        private String mobile1;
        @SerializedName("mobile_2")
        @Expose
        private String mobile2;
        @SerializedName("gender")
        @Expose
        private Integer gender;
        @SerializedName("dob")
        @Expose
        private String dob;
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
        private String pincode;
        @SerializedName("country")
        @Expose
        private String country;

        /**
         * No args constructor for use in serialization
         *
         */
        public Data() {
        }

        /**
         *
         * @param fname
         * @param pincode
         * @param country
         * @param address
         * @param gender
         * @param city
         * @param mobile1
         * @param lname
         * @param dob
         * @param mobile2
         * @param id
         * @param state
         * @param email
         */
        public Data(Integer id, String fname, String lname, String email, String  mobile1, String mobile2, Integer gender, String dob, String address, String city, String state, String pincode, String country) {
            super();
            this.id = id;
            this.fname = fname;
            this.lname = lname;
            this.email = email;
            this.mobile1 = mobile1;
            this.mobile2 = mobile2;
            this.gender = gender;
            this.dob = dob;
            this.address = address;
            this.city = city;
            this.state = state;
            this.pincode = pincode;
            this.country = country;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
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

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

    }

}