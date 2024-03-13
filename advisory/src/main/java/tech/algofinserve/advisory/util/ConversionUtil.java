package tech.algofinserve.advisory.util;

import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.model.domain.ChartInkScanRecord;
import tech.algofinserve.advisory.model.domain.Ticker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ConversionUtil {
    private final String  dateFormatForRequest="yyyy-mm-dd hh:mm";
    DateFormat df_yyyy_mm_dd_hh_mm = new SimpleDateFormat("yyyy-mm-dd hh:mm");
    public Ticker convertChartInkRecordToTicker(ChartInkScanRecord chartInkScanRecord){
        //Need to Revisit
        Ticker ticker=new Ticker();
        ticker.setStockSymbol(chartInkScanRecord.getStockName());
   //    ticker.setExchangeCode(chartInkScanRecord.getNseCode());

        return ticker;
    }


    public Date convertStringToDate(String dateString){


        Date date = null;
        try {
            date=df_yyyy_mm_dd_hh_mm.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public String convertDateToString(Date date){

        String result = df_yyyy_mm_dd_hh_mm.format(date);
        return result;

    }


}
