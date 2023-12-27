package tech.algofinserve.advisory.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.algofinserve.advisory.constants.BuySell;
import tech.algofinserve.advisory.constants.RecommendationStatus;
import tech.algofinserve.advisory.constants.RecommendationType;
import tech.algofinserve.advisory.constants.StockSegment;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;


public class Recommendation {

    public Recommendation() {}
    private  Long recommendationId;
    @JsonProperty("recommendedDate")
    Date recommendedDate;

    @JsonProperty("buySell")
    BuySell buySell;
    @JsonProperty("stock")
    String stock;
    @JsonProperty("stockSegment")
    StockSegment stockSegment;
    @JsonProperty("entryPrice")
    String entryPrice;
    @JsonProperty("targets")
    List<String> targets;
    @JsonProperty("stoploss1")

    String stoploss1;
    @JsonProperty("name")
    String stoploss2;
    @JsonProperty("stoploss2")
    String hardStoploss;
    @JsonProperty("expectedGain")
    String expectedGain;
    @JsonProperty("expectedGainInPercent")
    String expectedGainInPercent;
    @JsonProperty("recommendationType")
    RecommendationType recommendationType;
    @JsonProperty("recommendedBy")
    String recommendedBy;
    @JsonProperty("recommendationBasedOnScanner")
    String recommendationBasedOnScanner;
    @JsonProperty("updatedDate")
    Date updatedDate;
    @JsonProperty("updatedStatus")
    RecommendationStatus updatedStatus;
    @JsonProperty("active")
    boolean active;

    @JsonProperty("actualGain")
    String actualGain;
    @JsonProperty("actualGainInPercent")
    String actualGainInPercent;

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

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public StockSegment getStockSegment() {
        return stockSegment;
    }

    public void setStockSegment(StockSegment stockSegment) {
        this.stockSegment = stockSegment;
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
        this.targets = targets;
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


    public RecommendationType getRecommendationType() {
        return recommendationType;
    }

    public void setRecommendationType(RecommendationType recommendationType) {
        this.recommendationType = recommendationType;
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

    public String getRecommendedBy() {
        return recommendedBy;
    }

    public void setRecommendedBy(String recommendedBy) {
        this.recommendedBy = recommendedBy;
    }

    public String getRecommendationBasedOnScanner() {
        return recommendationBasedOnScanner;
    }

    public void setRecommendationBasedOnScanner(String recommendationBasedOnScanner) {
        this.recommendationBasedOnScanner = recommendationBasedOnScanner;
    }

    public Date getRecommendedDate() {
        return recommendedDate;
    }

    public void setRecommendedDate(Date recommendedDate) {
        this.recommendedDate = recommendedDate;
    }
}
