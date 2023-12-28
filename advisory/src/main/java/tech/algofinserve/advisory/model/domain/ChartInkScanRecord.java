package tech.algofinserve.advisory.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;


public class ChartInkScanRecord {

    public ChartInkScanRecord() {}

    Long sr;
    @JsonProperty("name")
    private String stockName;
    @JsonProperty("nsecode")
    private String nseCode;
    @JsonProperty("bsecode")
    private String bseCode;
    @JsonProperty("per_chg")
    private String percentChange;
    @JsonProperty("close")
    private String close;
    @JsonProperty("volume")
    private String volume;

    public ChartInkScanRecord(Long sr, String stockName, String nseCode, String bseCode, String percentChange, String close, String volume) {
        this.sr = sr;
        this.stockName = stockName;
        this.nseCode = nseCode;
        this.bseCode = bseCode;
        this.percentChange = percentChange;
        this.close = close;
        this.volume = volume;
    }

    public Long getSr() {
        return sr;
    }

    public void setSr(Long sr) {
        this.sr = sr;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getNseCode() {
        return nseCode;
    }

    public void setNseCode(String nseCode) {
        this.nseCode = nseCode;
    }

    public String getBseCode() {
        return bseCode;
    }

    public void setBseCode(String bseCode) {
        this.bseCode = bseCode;
    }

    public String getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(String percentChange) {
        this.percentChange = percentChange;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "ChartInkScanRecord{" +
                "sr=" + sr +
                ", stockName='" + stockName + '\'' +
                ", nseCode='" + nseCode + '\'' +
                ", bseCode='" + bseCode + '\'' +
                ", percentChange='" + percentChange + '\'' +
                ", close='" + close + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}
