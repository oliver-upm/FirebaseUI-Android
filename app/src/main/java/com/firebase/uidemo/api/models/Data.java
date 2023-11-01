package com.firebase.uidemo.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Data {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("supply")
    @Expose
    private String supply;
    @SerializedName("maxSupply")
    @Expose
    private String maxSupply;
    @SerializedName("marketCapUsd")
    @Expose
    private String marketCapUsd;
    @SerializedName("volumeUsd24Hr")
    @Expose
    private String volumeUsd24Hr;
    @SerializedName("priceUsd")
    @Expose
    private String priceUsd;
    @SerializedName("changePercent24Hr")
    @Expose
    private String changePercent24Hr;
    @SerializedName("vwap24Hr")
    @Expose
    private String vwap24Hr;
    @SerializedName("explorer")
    @Expose
    private String explorer;

    /**
     * No args constructor for use in serialization
     */
    public Data() {
    }

    /**
     * @param symbol
     * @param volumeUsd24Hr
     * @param marketCapUsd
     * @param priceUsd
     * @param vwap24Hr
     * @param changePercent24Hr
     * @param name
     * @param explorer
     * @param rank
     * @param id
     * @param maxSupply
     * @param supply
     */
    public Data(String id,
                String rank,
                String symbol,
                String name,
                String supply,
                String maxSupply,
                String marketCapUsd,
                String volumeUsd24Hr,
                String priceUsd,
                String changePercent24Hr,
                String vwap24Hr,
                String explorer) {
        super();
        this.id = id;
        this.rank = rank;
        this.symbol = symbol;
        this.name = name;
        this.supply = supply;
        this.maxSupply = maxSupply;
        this.marketCapUsd = marketCapUsd;
        this.volumeUsd24Hr = volumeUsd24Hr;
        this.priceUsd = priceUsd;
        this.changePercent24Hr = changePercent24Hr;
        this.vwap24Hr = vwap24Hr;
        this.explorer = explorer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    public String getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(String maxSupply) {
        this.maxSupply = maxSupply;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public String getVolumeUsd24Hr() {
        return volumeUsd24Hr;
    }

    public void setVolumeUsd24Hr(String volumeUsd24Hr) {
        this.volumeUsd24Hr = volumeUsd24Hr;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public String getChangePercent24Hr() {
        return changePercent24Hr;
    }

    public void setChangePercent24Hr(String changePercent24Hr) {
        this.changePercent24Hr = changePercent24Hr;
    }

    public String getVwap24Hr() {
        return vwap24Hr;
    }

    public void setVwap24Hr(String vwap24Hr) {
        this.vwap24Hr = vwap24Hr;
    }

    public String getExplorer() {
        return explorer;
    }

    public void setExplorer(String explorer) {
        this.explorer = explorer;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", rank='" + rank + '\'' +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", supply='" + supply + '\'' +
                ", maxSupply='" + maxSupply + '\'' +
                ", marketCapUsd='" + marketCapUsd + '\'' +
                ", volumeUsd24Hr='" + volumeUsd24Hr + '\'' +
                ", priceUsd='" + priceUsd + '\'' +
                ", changePercent24Hr='" + changePercent24Hr + '\'' +
                ", vwap24Hr='" + vwap24Hr + '\'' +
                ", explorer='" + explorer + '\'' +
                '}';
    }
}