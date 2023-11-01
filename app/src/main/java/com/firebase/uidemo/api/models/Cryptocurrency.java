
package com.firebase.uidemo.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Cryptocurrency {

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("timestamp")
    @Expose
    private Long timestamp;

    /**
     * No args constructor for use in serialization
     */
    public Cryptocurrency() {
    }

    /**
     * @param data
     * @param timestamp
     */
    public Cryptocurrency(Data data, Long timestamp) {
        super();
        this.data = data;
        this.timestamp = timestamp;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Cryptocurrency{" +
                "data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }
}