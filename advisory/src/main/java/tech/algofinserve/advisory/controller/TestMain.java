package tech.algofinserve.advisory.controller;

import com.angelbroking.smartapi.SmartConnect;
import org.json.JSONArray;
import org.json.JSONObject;
import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseBarSeries;
import org.ta4j.core.indicators.RSIIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import tech.algofinserve.advisory.constants.CandleTimeFrame;
import tech.algofinserve.advisory.constants.ExchangeSegment;
import tech.algofinserve.advisory.constants.InstrumentType;
import tech.algofinserve.advisory.model.domain.StockData;
import tech.algofinserve.advisory.model.domain.StockDataDaily;
import tech.algofinserve.advisory.model.domain.Ticker;
import tech.algofinserve.infra.AngelApiKey;
import tech.algofinserve.infra.AngelBrokerConnector;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class TestMain {

    public static void main(String[] args){
        SmartConnect smartConnect= AngelBrokerConnector.getSmartConnectSession(new AngelApiKey());
         JSONObject requestObejct = new JSONObject();

        requestObejct.put("exchange", "NSE");
        requestObejct.put("symboltoken", "2885");
        requestObejct.put("interval", CandleTimeFrame.ONE_DAY.value());
        requestObejct.put("fromdate", "2023-01-01 00:00");
        requestObejct.put("todate", "2024-01-18 00:00");
        JSONArray result= smartConnect.candleDataAsJSONArray(requestObejct);

        Set<StockData> stockDataDailyList=new LinkedHashSet<>();
        SimpleDateFormat simpleformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        Ticker ticker=new Ticker();
        ticker.setToken("2885");
        ticker.setStockSymbol("RELIANCE");
        ticker.setExchangeSegment(ExchangeSegment.NSE);
        ticker.setInstrumentType(InstrumentType.CASH);


        if(result !=null && result.length() >0){
    for(int i=0;i<result.length();i++){
        StockDataDaily stockDataDaily=new StockDataDaily();

        JSONArray array= result.getJSONArray(i);
        stockDataDaily.setId(String.valueOf(System.currentTimeMillis()));
        stockDataDaily.setTimestamp(getLocalDateTime(simpleformat, array.get(0).toString()));
        stockDataDaily.setOpen(Double.valueOf(array.get(1).toString()));
        stockDataDaily.setHigh(Double.valueOf(array.get(2).toString()));
        stockDataDaily.setLow(Double.valueOf(array.get(3).toString()));
        stockDataDaily.setClose(Double.valueOf(array.get(4).toString()));
        stockDataDaily.setVolume(Long.valueOf(array.get(5).toString()));

        stockDataDailyList.add(stockDataDaily);
        System.out.println(i+"obj::"+result.get(i));




    }
            BarSeries barSeries=convertBarSeriesFromStockData(ticker,CandleTimeFrame.ONE_DAY,stockDataDailyList);
            ClosePriceIndicator closePriceIndicator=new ClosePriceIndicator(barSeries);

            RSIIndicator rsiIndicator=new RSIIndicator(closePriceIndicator,14);
            System.out.println("Index ::259  ::Close Price:"+barSeries.getBar(259) +"RSI VALUE ::"+rsiIndicator.getValue(259));
            System.out.println("Index ::258  ::Close Price:"+barSeries.getBar(258) +"RSI VALUE ::"+rsiIndicator.getValue(258));
        }

    }

    private static String getBarSeriesName(Ticker ticker, CandleTimeFrame candleTimeFrame) {
        return new StringBuilder(ticker.getStockSymbol()).append("_")
                .append(candleTimeFrame.value()).append("_")
                .append(ticker.getExchangeSegment().value()).append("_")
                .append(ticker.getInstrumentType().value()).toString();
    }
    private static BarSeries convertBarSeriesFromStockData(Ticker ticker, CandleTimeFrame candleTimeFrame, Set<StockData> stockDataList){
        String barSeriesName= getBarSeriesName(ticker, candleTimeFrame);
        BarSeries baseBarSeries=new BaseBarSeries(barSeriesName);

        stockDataList.stream().forEach(p->{


            ZonedDateTime dateTime = ZonedDateTime.of(p.getTimestamp(),
                    ZoneId.systemDefault());

            baseBarSeries.addBar(dateTime, p.getOpen(), p.getHigh(), p.getLow(), p.getClose(), p.getVolume());
        });

        return baseBarSeries;
    }

    private static LocalDateTime getLocalDateTime(SimpleDateFormat simpleFormat, String dateString) {

        dateString= dateString.split("\\+")[0];

        LocalDateTime localDateTime = LocalDateTime.parse(dateString);

        return localDateTime;
    }

}
