package com.tetravalstartups.kgs.auth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClientMedia {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private List<ClientMediaResponse> data = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ClientMedia() {
    }

    /**
     *
     * @param data
     * @param status
     */
    public ClientMedia(Boolean status, List<ClientMediaResponse> data) {
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

    public List<ClientMediaResponse> getData() {
        return data;
    }

    public void setData(List<ClientMediaResponse> data) {
        this.data = data;
    }

}
