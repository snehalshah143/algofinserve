package tech.algofinserve.advisory.controller;

import com.angelbroking.smartapi.SmartConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;
import tech.algofinserve.advisory.constants.CandleTimeFrame;
import tech.algofinserve.advisory.constants.ExchangeSegment;
import tech.algofinserve.advisory.constants.InstrumentType;
import tech.algofinserve.advisory.model.domain.StockData;
import tech.algofinserve.advisory.model.domain.Ticker;
import tech.algofinserve.advisory.service.MetaDataService;
import tech.algofinserve.advisory.util.ConversionUtil;
import tech.algofinserve.angel.AngelApiKey;
import tech.algofinserve.angel.AngelBrokerConnector;
import tech.algofinserve.advisory.service.AngelMarketDataServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
public class MarketDataController {


    @Autowired
    AngelMarketDataServiceImpl angelMarketDataServiceImpl;

    @Autowired
    ConversionUtil conversionUtil;
    @Autowired
    MetaDataService metaDataService;
    SmartConnect smartConnect=AngelBrokerConnector.getSmartConnectSession(new AngelApiKey());

    @PostMapping(path = "/marketdata/angel/downloadmarketdata")
    public ResponseEntity<String> downloadMarketData() {

        Ticker ticker=new Ticker();
        ticker.setToken(metaDataService.getInstrumentTickerForStockName("RELIANCE",ExchangeSegment.NSE).getToken());
        ticker.setStockSymbol("RELIANCE");
        ticker.setExchangeSegment(ExchangeSegment.NSE);
        ticker.setInstrumentType(InstrumentType.CASH);
        String fromDate="2023-01-01 00:00";

        String toDate="2024-01-17 00:00";


        Set<StockData> stockDataList= angelMarketDataServiceImpl.getHistoricalDataForTicker(smartConnect,ticker, CandleTimeFrame.ONE_DAY,fromDate,toDate);

        return new ResponseEntity<String>("Data Download Completed.", HttpStatus.OK);

    }

    @PostMapping(path = "/marketdata/angel/getmarketdata")
    public ResponseEntity<Set<StockData>> getStockData() {

        Ticker ticker=new Ticker();
        ticker.setToken(metaDataService.getInstrumentTickerForStockName("RELIANCE",ExchangeSegment.NSE).getToken());
        ticker.setStockSymbol("RELIANCE");
        ticker.setExchangeSegment(ExchangeSegment.NSE);

        String fromDate="2023-01-01 00:00";

        String toDate="2024-01-17 00:00";


        Set<StockData> stockDataList= angelMarketDataServiceImpl.getStockDataForTimeFrame(ticker.getStockSymbol(), CandleTimeFrame.ONE_DAY);

        return new ResponseEntity<Set<StockData>>( stockDataList, HttpStatus.OK);

    }

    @PostMapping(path = "/marketdata/angel/getbarseries")
    public ResponseEntity<List<Bar>> getBarSeriesData() {

        Ticker ticker=new Ticker();
        ticker.setToken(metaDataService.getInstrumentTickerForStockName("RELIANCE",ExchangeSegment.NSE).getToken());
        ticker.setStockSymbol("RELIANCE");
        ticker.setExchangeSegment(ExchangeSegment.NSE);
        ticker.setInstrumentType(InstrumentType.CASH);
        String fromDate="2023-01-01 00:00";

        String toDate="2024-01-17 00:00";


        List<Bar> barList= angelMarketDataServiceImpl.getBarSeries(ticker.getStockSymbol(), CandleTimeFrame.ONE_DAY);

        return new ResponseEntity<List<Bar>>(barList, HttpStatus.OK);

    }
}
