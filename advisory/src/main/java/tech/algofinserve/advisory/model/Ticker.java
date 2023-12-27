package tech.algofinserve.advisory.model;

public class Ticker {

    String stockName;
    String bseCode;
    String nseCode;
    String sector;
    String categorization;

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getBseCode() {
        return bseCode;
    }

    public void setBseCode(String bseCode) {
        this.bseCode = bseCode;
    }

    public String getNseCode() {
        return nseCode;
    }

    public void setNseCode(String nseCode) {
        this.nseCode = nseCode;
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
}
