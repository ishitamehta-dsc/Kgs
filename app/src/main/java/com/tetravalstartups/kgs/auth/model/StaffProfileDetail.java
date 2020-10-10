package com.tetravalstartups.kgs.auth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StaffProfileDetail {

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
    public StaffProfileDetail() {
    }

    /**
     *
     * @param data
     * @param type
     * @param status
     */
    public StaffProfileDetail(Boolean status, Integer type, Data data) {
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
        @SerializedName("profile_pic")
        @Expose
        private String profilePic;
        @SerializedName("joining_date")
        @Expose
        private String joiningDate;
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
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("profile_image")
        @Expose
        private String profileImage;

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
         * @param profilePic
         * @param mobile1
         * @param joiningDate
         * @param profileImage
         * @param lname
         * @param createdDate
         * @param dob
         * @param mobile2
         * @param id
         * @param state
         * @param email
         * @param status
         */
        public Data(Integer id, String fname, String lname, String email, String mobile1, String mobile2, Integer gender, String dob, String profilePic, String joiningDate, String address, String city, String state, Integer pincode, String country, String createdDate, Integer status, String profileImage) {
            super();
            this.id = id;
            this.fname = fname;
            this.lname = lname;
            this.email = email;
            this.mobile1 = mobile1;
            this.mobile2 = mobile2;
            this.gender = gender;
            this.dob = dob;
            this.profilePic = profilePic;
            this.joiningDate = joiningDate;
            this.address = address;
            this.city = city;
            this.state = state;
            this.pincode = pincode;
            this.country = country;
            this.createdDate = createdDate;
            this.status = status;
            this.profileImage = profileImage;
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

        public String getProfilePic() {
            return profilePic;
        }

        public void setProfilePic(String profilePic) {
            this.profilePic = profilePic;
        }

        public String getJoiningDate() {
            return joiningDate;
        }

        public void setJoiningDate(String joiningDate) {
            this.joiningDate = joiningDate;
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

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

    }

}