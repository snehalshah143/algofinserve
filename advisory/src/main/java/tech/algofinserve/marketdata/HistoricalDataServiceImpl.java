package tech.algofinserve.marketdata;

import tech.algofinserve.advisory.constants.CandleTimeFrame;
import tech.algofinserve.advisory.model.domain.Candle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HistoricalDataServiceImpl {

    //Stock Code as Key
    public static Map<String,Map<CandleTimeFrame, Candle>> historicalStockPrices=new ConcurrentHashMap<>();


}
