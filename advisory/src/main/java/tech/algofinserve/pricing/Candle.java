package tech.algofinserve.pricing;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.algofinserve.advisory.model.domain.CandleTimeFrame;

import java.util.Date;

public class Candle {

    long candleNum;

    @JsonProperty("timeFrame")
    private CandleTimeFrame timeFrame;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("series")
    private String series;
    @JsonProperty("timestamp")
    private Date timestamp;
    @JsonProperty("open")
    private double open;
    @JsonProperty("high")
    private double high;
    @JsonProperty("low")
    private double low;
    @JsonProperty("close")
    private double close;
    @JsonProperty("volume")
    private long volume;



}
