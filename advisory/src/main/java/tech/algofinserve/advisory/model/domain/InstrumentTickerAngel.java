package tech.algofinserve.advisory.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class InstrumentTickerAngel extends InstrumentTicker implements Serializable {


    @JsonProperty("token")
    private String token;

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("name")
    private String name;

    @JsonProperty("expiry")
    private String expiry;

    @JsonProperty("strike")
    private String strike;

    @JsonProperty("lotsize")
    private String lotsize;


    @JsonProperty("instrumenttype")
    private String instrumenttype;

    @JsonProperty("exch_seg")
    private String exchSeg;

    @JsonProperty("tick_size")
    private String tickSize;


    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getStrike() {
        return strike;
    }

    public void setStrike(String strike) {
        this.strike = strike;
    }

    public String getLotsize() {
        return lotsize;
    }

    public void setLotsize(String lotsize) {
        this.lotsize = lotsize;
    }

    public String getInstrumenttype() {
        return instrumenttype;
    }

    public void setInstrumenttype(String instrumenttype) {
        this.instrumenttype = instrumenttype;
    }

    public String getExchSeg() {
        return exchSeg;
    }

    public void setExchSeg(String exchSeg) {
        this.exchSeg = exchSeg;
    }

    public String getTickSize() {
        return tickSize;
    }

    public void setTickSize(String tickSize) {
        this.tickSize = tickSize;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
}
