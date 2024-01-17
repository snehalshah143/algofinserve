package tech.algofinserve.advisory.controller;

import com.angelbroking.smartapi.SmartConnect;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.algofinserve.advisory.constants.CandleTimeFrame;
import tech.algofinserve.advisory.model.domain.StockDataDaily;
import tech.algofinserve.angel.AngelApiKey;
import tech.algofinserve.angel.AngelBrokerConnector;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestMain {

    public static void main(String[] args){
        SmartConnect smartConnect= AngelBrokerConnector.getSmartConnectSession(new AngelApiKey());

        JSONObject requestObejct = new JSONObject();

        requestObejct.put("exchange", "NSE");
        requestObejct.put("symboltoken", "2885");
        requestObejct.put("interval", CandleTimeFrame.ONE_MINUTE.value());
        requestObejct.put("fromdate", "2024-01-01 00:00");
        requestObejct.put("todate", "2024-01-02 00:00");
        JSONArray result= smartConnect.candleDataAsJSONArray(requestObejct);

        List<StockDataDaily> stockDataDailyList=new LinkedList<>();
        SimpleDateFormat simpleformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        if(result !=null && result.length() >0){
    for(int i=0;i<result.length();i++){
        StockDataDaily stockDataDaily=new StockDataDaily();

        JSONArray array= result.getJSONArray(i);
        stockDataDaily.setId(System.currentTimeMillis());
        stockDataDaily.setTimestamp(getDate(simpleformat, array.get(0).toString()));
        stockDataDaily.setOpen(Double.valueOf(array.get(1).toString()));
        stockDataDaily.setHigh(Double.valueOf(array.get(2).toString()));
        stockDataDaily.setLow(Double.valueOf(array.get(3).toString()));
        stockDataDaily.setClose(Double.valueOf(array.get(4).toString()));
        stockDataDaily.setVolume(Long.valueOf(array.get(5).toString()));

        stockDataDailyList.add(stockDataDaily);
        System.out.println(i+"obj::"+result.get(i));

    }
}

    }

    private static Date getDate(SimpleDateFormat simpleFormat, String dateString) {
        Date date;
        dateString= dateString.split("\\+")[0];


        try {
            date = simpleFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

}
