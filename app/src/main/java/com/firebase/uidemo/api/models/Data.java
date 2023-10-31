
package com.firebase.uidemo.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Data {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("rank")
    @Expose
    public String rank;
    @SerializedName("symbol")
    @Expose
    public String symbol;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("supply")
    @Expose
    public String supply;
    @SerializedName("maxSupply")
    @Expose
    public String maxSupply;
    @SerializedName("marketCapUsd")
    @Expose
    public String marketCapUsd;
    @SerializedName("volumeUsd24Hr")
    @Expose
    public String volumeUsd24Hr;
    @SerializedName("priceUsd")
    @Expose
    public String priceUsd;
    @SerializedName("changePercent24Hr")
    @Expose
    public String changePercent24Hr;
    @SerializedName("vwap24Hr")
    @Expose
    public String vwap24Hr;
    @SerializedName("explorer")
    @Expose
    public String explorer;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Data.class.getName())
                .append('@')
                .append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("rank");
        sb.append('=');
        sb.append(((this.rank == null) ? "<null>" : this.rank));
        sb.append(',');
        sb.append("symbol");
        sb.append('=');
        sb.append(((this.symbol == null) ? "<null>" : this.symbol));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("supply");
        sb.append('=');
        sb.append(((this.supply == null) ? "<null>" : this.supply));
        sb.append(',');
        sb.append("maxSupply");
        sb.append('=');
        sb.append(((this.maxSupply == null) ? "<null>" : this.maxSupply));
        sb.append(',');
        sb.append("marketCapUsd");
        sb.append('=');
        sb.append(((this.marketCapUsd == null) ? "<null>" : this.marketCapUsd));
        sb.append(',');
        sb.append("volumeUsd24Hr");
        sb.append('=');
        sb.append(((this.volumeUsd24Hr == null) ? "<null>" : this.volumeUsd24Hr));
        sb.append(',');
        sb.append("priceUsd");
        sb.append('=');
        sb.append(((this.priceUsd == null) ? "<null>" : this.priceUsd));
        sb.append(',');
        sb.append("changePercent24Hr");
        sb.append('=');
        sb.append(((this.changePercent24Hr == null) ? "<null>" : this.changePercent24Hr));
        sb.append(',');
        sb.append("vwap24Hr");
        sb.append('=');
        sb.append(((this.vwap24Hr == null) ? "<null>" : this.vwap24Hr));
        sb.append(',');
        sb.append("explorer");
        sb.append('=');
        sb.append(((this.explorer == null) ? "<null>" : this.explorer));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
