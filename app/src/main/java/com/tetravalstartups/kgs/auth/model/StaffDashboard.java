package com.tetravalstartups.kgs.auth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StaffDashboard {
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
    public StaffDashboard() {
    }

    /**
     *
     * @param data
     * @param status
     */
    public StaffDashboard(Boolean status, Data data) {
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

        @SerializedName("complted_task_shift1")
        @Expose
        private Integer compltedTaskShift1;
        @SerializedName("complted_task_shift2")
        @Expose
        private Integer compltedTaskShift2;
        @SerializedName("pending_task_shift1")
        @Expose
        private Integer pendingTaskShift1;
        @SerializedName("pending_task_shift2")
        @Expose
        private Integer pendingTaskShift2;

        /**
         * No args constructor for use in serialization
         *
         */
        public Data() {
        }

        /**
         *
         * @param compltedTaskShift2
         * @param compltedTaskShift1
         * @param pendingTaskShift2
         * @param pendingTaskShift1
         */
        public Data(Integer compltedTaskShift1, Integer compltedTaskShift2, Integer pendingTaskShift1, Integer pendingTaskShift2) {
            super();
            this.compltedTaskShift1 = compltedTaskShift1;
            this.compltedTaskShift2 = compltedTaskShift2;
            this.pendingTaskShift1 = pendingTaskShift1;
            this.pendingTaskShift2 = pendingTaskShift2;
        }

        public Integer getCompltedTaskShift1() {
            return compltedTaskShift1;
        }

        public void setCompltedTaskShift1(Integer compltedTaskShift1) {
            this.compltedTaskShift1 = compltedTaskShift1;
        }

        public Integer getCompltedTaskShift2() {
            return compltedTaskShift2;
        }

        public void setCompltedTaskShift2(Integer compltedTaskShift2) {
            this.compltedTaskShift2 = compltedTaskShift2;
        }

        public Integer getPendingTaskShift1() {
            return pendingTaskShift1;
        }

        public void setPendingTaskShift1(Integer pendingTaskShift1) {
            this.pendingTaskShift1 = pendingTaskShift1;
        }

        public Integer getPendingTaskShift2() {
            return pendingTaskShift2;
        }

        public void setPendingTaskShift2(Integer pendingTaskShift2) {
            this.pendingTaskShift2 = pendingTaskShift2;
        }

    }
}
