package tech.algofinserve.advisory.service;

import com.angelbroking.smartapi.SmartConnect;
import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;
import tech.algofinserve.advisory.constants.CandleTimeFrame;
import tech.algofinserve.advisory.model.domain.StockData;
import tech.algofinserve.advisory.model.domain.Ticker;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface AngelMarketDataService {

    Set<StockData> getHistoricalDataForTicker(SmartConnect smartConnect, Ticker ticker, CandleTimeFrame candleTimeFrame, String fromDate, String toDate);

     void addStockDataToStore(Ticker ticker,CandleTimeFrame candleTimeFrame,Set<StockData> stockDataList);

     Set<StockData> getStockDataForTimeFrame(String stockSymbol,CandleTimeFrame candleTimeFrame);

         Set<StockData> getStockDataForRange(String stockSymbol,CandleTimeFrame candleTimeFrame,Date fromDate ,Date toDate);
             public List<Bar> getBarSeries(String stockSymbol, CandleTimeFrame candleTimeFrame);
                 public List<Bar> getBarSeriesForRange(String stockSymbol,CandleTimeFrame candleTimeFrame,Date fromDate ,Date toDate);


}
