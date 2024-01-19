package tech.algofinserve.advisory.model.domain;

public class RSI {

    private Double rsi;

    private Double rsiema9;

    private Double rsiema21;

    public RSI(Double rsi, Double rsiema9, Double rsiema21) {
        this.rsi = rsi;
        this.rsiema9 = rsiema9;
        this.rsiema21 = rsiema21;
    }

    public Double getRsi() {
        return rsi;
    }

    public Double getRsiema9() {
        return rsiema9;
    }

    public Double getRsiema21() {
        return rsiema21;
    }
}
