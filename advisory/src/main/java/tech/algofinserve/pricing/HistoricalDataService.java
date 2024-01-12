package tech.algofinserve.pricing;

import tech.algofinserve.advisory.model.domain.TimeFrame;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HistoricalDataService {

    //NSE Code as Key
    public static Map<String,Map<TimeFrame,Candle>> historicalStockPrices=new ConcurrentHashMap<>();


}
