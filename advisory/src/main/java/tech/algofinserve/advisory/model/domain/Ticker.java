package tech.algofinserve.advisory.model.domain;

import tech.algofinserve.advisory.constants.ExchangeSegment;
import tech.algofinserve.advisory.constants.InstrumentType;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;


public class Ticker implements Serializable {
    String token;
    String stockCode;
    InstrumentType instrumentType;
    ExchangeSegment exchangeSegment;

    String exchangeCode;
    String sector;
    String categorization;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
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

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCategorization() {
        return categorization;
    }

    public void setCategorization(String categorization) {
        this.categorization = categorization;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticker ticker = (Ticker) o;
        return token.equals(ticker.token) && stockCode.equals(ticker.stockCode) && instrumentType == ticker.instrumentType && exchangeSegment == ticker.exchangeSegment && Objects.equals(sector, ticker.sector) && Objects.equals(categorization, ticker.categorization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, stockCode, instrumentType, exchangeSegment, sector, categorization);
    }
}
