package tech.algofinserve.advisory.service;

import com.angelbroking.smartapi.SmartConnect;
import tech.algofinserve.advisory.constants.CandleTimeFrame;
import tech.algofinserve.advisory.model.domain.StockData;
import tech.algofinserve.advisory.model.domain.Ticker;

import java.util.Date;
import java.util.List;

public interface AngelMarketDataService {

    public List<StockData> getHistoricalDataForTicker(SmartConnect smartConnect, Ticker ticker, CandleTimeFrame candleTimeFrame, String fromDate, String toDate);
}
