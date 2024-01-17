package tech.algofinserve.advisory.service;

import com.angelbroking.smartapi.SmartConnect;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.algofinserve.advisory.constants.CandleTimeFrame;
import tech.algofinserve.advisory.factory.StockDataFactory;
import tech.algofinserve.advisory.model.domain.StockData;
import tech.algofinserve.advisory.model.domain.StockDataDaily;
import tech.algofinserve.advisory.model.domain.Ticker;
import tech.algofinserve.advisory.util.ConversionUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AngelMarketDataServiceImpl implements AngelMarketDataService{

    //StockName vrs Map<TimeFrame,StockData>
    private Map<String,Map<CandleTimeFrame,List<StockData>>> stockPricesStore=new ConcurrentHashMap<>();

    SimpleDateFormat simpleDateFormatAngel = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    @Autowired
    ConversionUtil conversionUtil;

    public  List<StockData> getHistoricalDataForTicker(SmartConnect smartConnect, Ticker ticker, CandleTimeFrame candleTimeFrame,String fromDate,String toDate)  {
/*
        JSONObject requestObejct = new JSONObject();

       requestObejct.put("exchange", "NSE");
        requestObejct.put("symboltoken", "3045");
        requestObejct.put("interval", "ONE_MINUTE");
        requestObejct.put("fromdate", "2023-12-29 09:00");
        requestObejct.put("todate", "2023-12-29 09:20");*/

        JSONObject requestObject =
        constructHistoricalDataRequest(ticker, candleTimeFrame, fromDate, toDate);
        JSONArray result = smartConnect.candleDataAsJSONArray(requestObject);

        List<StockData> stockDataDailyList=  convertRawDataToStockDataList(result,ticker,candleTimeFrame);

        return stockDataDailyList;
    }

    private List<StockData> convertRawDataToStockDataList(JSONArray result,Ticker ticker, CandleTimeFrame candleTimeFrame) {
        List<StockData> stockDataList=new LinkedList<>();

        if(result !=null && result.length() >0){
            for(int i = 0; i< result.length(); i++){
                StockData stockData= StockDataFactory.getStockDataObject(candleTimeFrame);

                JSONArray array= result.getJSONArray(i);
                populateBasicStockData(ticker, candleTimeFrame, stockData);
                populateOHLCVStockData(stockData, array);
                stockDataList.add(stockData);
            }
        }
        return stockDataList;
    }

    private void populateOHLCVStockData(StockData stockData, JSONArray array) {
        stockData.setTimestamp(getDate(simpleDateFormatAngel, array.get(0).toString()));
        stockData.setOpen(Double.valueOf(array.get(1).toString()));
        stockData.setHigh(Double.valueOf(array.get(2).toString()));
        stockData.setLow(Double.valueOf(array.get(3).toString()));
        stockData.setClose(Double.valueOf(array.get(4).toString()));
        stockData.setVolume(Long.valueOf(array.get(5).toString()));
    }

    private static void populateBasicStockData(Ticker ticker, CandleTimeFrame candleTimeFrame, StockData stockData) {
        stockData.setId(System.currentTimeMillis());
        stockData.setCandleNum(StockDataFactory.getStockDataCandleNumber(candleTimeFrame));
        stockData.setExchangeSegment(ticker.getExchangeSegment());
        stockData.setInstrumentType(ticker.getInstrumentType());
        stockData.setSymbol(ticker.getStockCode());
        stockData.setTimeFrame(candleTimeFrame);
    }

    private Date getDate(SimpleDateFormat simpleFormat, String dateString) {
        Date date;
        dateString= dateString.split("\\+")[0];


        try {
            date = simpleFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
    private JSONObject constructHistoricalDataRequest(Ticker ticker, CandleTimeFrame candleTimeFrame, String fromDate, String toDate) {
        // String  dateFormatForRequest="yyyy-mm-dd hh:mm";
        JSONObject requestObject = new JSONObject();
        requestObject.put("exchange", ticker.getExchangeSegment().value());
        requestObject.put("symboltoken", ticker.getToken());
        requestObject.put("interval", candleTimeFrame.value());
        requestObject.put("fromdate", fromDate);
        requestObject.put("todate", toDate);
        return requestObject;
    }

public void addStockDataToStore(String stockSymbol,CandleTimeFrame candleTimeFrame,List<StockData> stockDataList) {
    saveStockData(candleTimeFrame,stockDataList);
    if(stockPricesStore.containsKey(stockSymbol)){
      Map<CandleTimeFrame,List<StockData>> stockDataMap= stockPricesStore.get(stockSymbol);

      if(stockDataMap.containsKey(candleTimeFrame)){
          stockDataMap.get(candleTimeFrame).addAll(stockDataList);
      }else{
          stockDataMap.put(candleTimeFrame,stockDataList);
      }
    }else{
        Map<CandleTimeFrame,List<StockData>> stockDataMap= new ConcurrentHashMap<>();
        stockDataMap.put(candleTimeFrame,stockDataList);
        stockPricesStore.put(stockSymbol,stockDataMap);
    }
}

private void saveStockData(CandleTimeFrame candleTimeFrame,List<StockData> stockDataList){

    StockDataFactory.getStockDataRepository(candleTimeFrame).saveAll(stockDataList);
}

public List<StockData> getStockDataForTimeFrame(String stockSymbol,CandleTimeFrame candleTimeFrame){

        return stockPricesStore.get(stockSymbol).get(candleTimeFrame);
}

    public List<StockData> getStockDataForRange(String stockSymbol,CandleTimeFrame candleTimeFrame,Date fromDate ,Date toDate){

        return stockPricesStore.get(stockSymbol).get(candleTimeFrame);
    }


}
