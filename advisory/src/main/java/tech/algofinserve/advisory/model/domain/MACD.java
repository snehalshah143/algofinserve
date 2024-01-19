package tech.algofinserve.advisory.model.domain;

public class MACD {

    private Double macd;
    private Double macdSignal;

    private Double macdHistogram;

    public MACD(Double macd, Double macdSignal, Double macdHistogram) {
        this.macd = macd;
        this.macdSignal = macdSignal;
        this.macdHistogram = macdHistogram;
    }

    public Double getMacd() {
        return macd;
    }


    public Double getMacdSignal() {
        return macdSignal;
    }



    public Double getMacdHistogram() {
        return macdHistogram;
    }


}
