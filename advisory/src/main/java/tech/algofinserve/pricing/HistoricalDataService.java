package tech.algofinserve.pricing;

import tech.algofinserve.advisory.model.domain.CandleTimeFrame;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HistoricalDataService {

    //NSE Code as Key
    public static Map<String,Map<CandleTimeFrame,Candle>> historicalStockPrices=new ConcurrentHashMap<>();


}
