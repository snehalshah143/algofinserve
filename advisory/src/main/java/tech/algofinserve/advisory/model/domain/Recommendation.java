package tech.algofinserve.advisory.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.algofinserve.advisory.constants.*;


import java.util.Date;
import java.util.List;


public class Recommendation {

    public Recommendation() {}
    private  Long recommendationId;
    @JsonProperty("recommendedDate")
    Date recommendedDate;

    @JsonProperty("instrumentType")
    InstrumentType instrumentType;
    @JsonProperty("buySell")
    BuySell buySell;
    @JsonProperty("stockCode")
    String stockCode;

    @JsonProperty("ticker")
    Ticker ticker;


    @JsonProperty("exchangeSegment")
    ExchangeSegment exchangeSegment;
    @JsonProperty("entryPrice")
    String entryPrice;
    @JsonProperty("targets")
    List<String> targets;
    @JsonProperty("stoploss1")

    String stoploss1;
    @JsonProperty("stoploss2")
    String stoploss2;
    @JsonProperty("hardStoploss")
    String hardStoploss;
    @JsonProperty("expectedGain")
    String expectedGain;
    @JsonProperty("expectedGainInPercent")
    String expectedGainInPercent;
    @JsonProperty("recommendedBy")
    RecommendedBy recommendedBy;
    @JsonProperty("scannerName")
    ScannerName scannerName;
    @JsonProperty("updatedDate")
    Date updatedDate;
    @JsonProperty("updatedStatus")
    RecommendationStatus updatedStatus;
    @JsonProperty("active")
    Boolean active;

    @JsonProperty("actualGain")
    String actualGain;
    @JsonProperty("actualGainInPercent")
    String actualGainInPercent;
    @JsonProperty("recommendationValidity")
    RecommendationValidity recommendationValidity;

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public RecommendationStatus getUpdatedStatus() {
        return updatedStatus;
    }

    public void setUpdatedStatus(RecommendationStatus updatedStatus) {
        this.updatedStatus = updatedStatus;
    }

    public Long getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(Long recommendationId) {
        this.recommendationId = recommendationId;
    }

    public BuySell getBuySell() {
        return buySell;
    }

    public void setBuySell(BuySell buySell) {
        this.buySell = buySell;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    public ExchangeSegment getExchangeSegment() {
        return exchangeSegment;
    }

    public void setExchangeSegment(ExchangeSegment exchangeSegment) {
        this.exchangeSegment = exchangeSegment;
    }

    public String getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(String entryPrice) {
        this.entryPrice = entryPrice;
    }

    public List<String> getTargets() {
        return targets;
    }

    public void setTargets(List<String> targets) {
        this.targets=targets;
    }

    public String getStoploss1() {
        return stoploss1;
    }

    public void setStoploss1(String stoploss1) {
        this.stoploss1 = stoploss1;
    }

    public String getStoploss2() {
        return stoploss2;
    }

    public void setStoploss2(String stoploss2) {
        this.stoploss2 = stoploss2;
    }

    public String getHardStoploss() {
        return hardStoploss;
    }

    public void setHardStoploss(String hardStoploss) {
        this.hardStoploss = hardStoploss;
    }


    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public Boolean getActive() {
        return active;
    }

    public String getExpectedGain() {
        return expectedGain;
    }

    public void setExpectedGain(String expectedGain) {
        this.expectedGain = expectedGain;
    }

    public String getExpectedGainInPercent() {
        return expectedGainInPercent;
    }

    public void setExpectedGainInPercent(String expectedGainInPercent) {
        this.expectedGainInPercent = expectedGainInPercent;
    }

    public RecommendedBy getRecommendedBy() {
        return recommendedBy;
    }

    public void setRecommendedBy(RecommendedBy recommendedBy) {
        this.recommendedBy = recommendedBy;
    }

    public ScannerName getScannerName() {
        return scannerName;
    }

    public void setScannerName(ScannerName scannerName) {
        this.scannerName = scannerName;
    }

    public Date getRecommendedDate() {
        return recommendedDate;
    }

    public void setRecommendedDate(Date recommendedDate) {
        this.recommendedDate = recommendedDate;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getActualGain() {
        return actualGain;
    }

    public void setActualGain(String actualGain) {
        this.actualGain = actualGain;
    }

    public String getActualGainInPercent() {
        return actualGainInPercent;
    }

    public void setActualGainInPercent(String actualGainInPercent) {
        this.actualGainInPercent = actualGainInPercent;
    }

    public RecommendationValidity getRecommendationValidity() {
        return recommendationValidity;
    }

    public void setRecommendationValidity(RecommendationValidity recommendationValidity) {
        this.recommendationValidity = recommendationValidity;
    }

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }
}
