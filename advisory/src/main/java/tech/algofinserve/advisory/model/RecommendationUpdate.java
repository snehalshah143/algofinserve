package tech.algofinserve.advisory.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.algofinserve.advisory.constants.BuySell;
import tech.algofinserve.advisory.constants.RecommendationStatus;
import tech.algofinserve.advisory.constants.RecommendationType;
import tech.algofinserve.advisory.constants.StockSegment;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class RecommendationUpdate {

    public RecommendationUpdate() {}
    private @Id
    //   @GeneratedValue(strategy = GenerationType.TABLE)
    Long recommendationId;
    @JsonProperty("buySell")
    BuySell buySell;
    @JsonProperty("stock")
    Ticker stock;
    @JsonProperty("stockSegment")
    StockSegment stockSegment;
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
    @JsonProperty("actualGain")
    String actualGain;
    @JsonProperty("actualGainInPercent")
    String actualGainInPercent;
    @JsonProperty("recommendationType")
    RecommendationType recommendationType;
    @JsonProperty("recommendationStatus")
    RecommendationStatus recommendationStatus;
    @JsonProperty("active")
    boolean active;

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

    public Ticker getStock() {
        return stock;
    }

    public void setStock(Ticker stock) {
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

    public RecommendationStatus getRecommendationStatus() {
        return recommendationStatus;
    }

    public void setRecommendationStatus(RecommendationStatus recommendationStatus) {
        this.recommendationStatus = recommendationStatus;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
