package tech.algofinserve.advisory.controller;

import com.angelbroking.smartapi.SmartConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.algofinserve.advisory.constants.CandleTimeFrame;
import tech.algofinserve.advisory.constants.ExchangeSegment;
import tech.algofinserve.advisory.model.domain.Ticker;
import tech.algofinserve.advisory.service.MetaDataService;
import tech.algofinserve.advisory.util.ConversionUtil;
import tech.algofinserve.angel.AngelApiKey;
import tech.algofinserve.angel.AngelBrokerConnector;
import tech.algofinserve.advisory.service.AngelMarketDataServiceImpl;

import java.util.Date;

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
        ticker.setStockCode("RELIANCE");
        ticker.setExchangeSegment(ExchangeSegment.NSE);

        String fromDate="2024-01-01 00:00";

        String toDate="2024-01-17 00:00";


        angelMarketDataServiceImpl.getHistoricalDataForTicker(smartConnect,ticker, CandleTimeFrame.ONE_DAY,fromDate,toDate);
        return new ResponseEntity<String>("Instrument Ticker Loading Completed.", HttpStatus.OK);

    }
}
