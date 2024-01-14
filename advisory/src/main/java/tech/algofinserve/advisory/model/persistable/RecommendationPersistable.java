package tech.algofinserve.advisory.model.persistable;

import org.springframework.data.mongodb.core.mapping.Document;
import tech.algofinserve.advisory.constants.BuySell;
import tech.algofinserve.advisory.constants.ExchangeSegment;
import tech.algofinserve.advisory.constants.RecommendationStatus;
import tech.algofinserve.advisory.constants.ScannerName;
import tech.algofinserve.advisory.model.domain.RecommendationValidity;
import tech.algofinserve.advisory.model.domain.RecommendedBy;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document(collection = "recommendation")
public class RecommendationPersistable implements Serializable {

    public RecommendationPersistable() {}
    private  Long recommendationId;

    Date recommendedDate;


    BuySell buySell;

    String symbol;

    ExchangeSegment exchangeSegment;

    String entryPrice;

    List<String> targets;


    String stoploss1;

    String stoploss2;

    String hardStoploss;

    String expectedGain;

    String expectedGainInPercent;

    RecommendationValidity recommendationValidity;

    RecommendedBy recommendedBy;

    ScannerName scannerName;

    Date updatedDate;

    RecommendationStatus updatedStatus;

    Boolean active;


    String actualGain;

    String actualGainInPercent;

    RecommendationValidity recommendationTimeframe;

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


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public RecommendationValidity getRecommendationValidity() {
        return recommendationValidity;
    }

    public void setRecommendationValidity(RecommendationValidity recommendationValidity) {
        this.recommendationValidity = recommendationValidity;
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

    public RecommendationValidity getRecommendationTimeframe() {
        return recommendationTimeframe;
    }

    public void setRecommendationTimeframe(RecommendationValidity recommendationTimeframe) {
        this.recommendationTimeframe = recommendationTimeframe;
    }
}
