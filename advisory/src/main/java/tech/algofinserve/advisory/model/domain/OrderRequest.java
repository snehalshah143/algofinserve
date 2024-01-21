package tech.algofinserve.advisory.model.domain;

import tech.algofinserve.advisory.constants.BuySell;

import java.time.LocalDateTime;

public class OrderRequest {

    private String orderRequestId;

    private String exchangeOrderId;

    private  Recommendation recommendation;

    LocalDateTime orderRequestDate;

    BuySell buySell;

    Integer quantity;

    Double entryPrice;
    public String ordertype;

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public String getOrderRequestId() {
        return orderRequestId;
    }

    public void setOrderRequestId(String orderRequestId) {
        this.orderRequestId = orderRequestId;
    }

    public Recommendation getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Recommendation recommendation) {
        this.recommendation = recommendation;
    }

    public String getExchangeOrderId() {
        return exchangeOrderId;
    }

    public void setExchangeOrderId(String exchangeOrderId) {
        this.exchangeOrderId = exchangeOrderId;
    }

    public LocalDateTime getOrderRequestDate() {
        return orderRequestDate;
    }

    public void setOrderRequestDate(LocalDateTime orderRequestDate) {
        this.orderRequestDate = orderRequestDate;
    }

    public BuySell getBuySell() {
        return buySell;
    }

    public void setBuySell(BuySell buySell) {
        this.buySell = buySell;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(Double entryPrice) {
        this.entryPrice = entryPrice;
    }
}
