package tech.algofinserve.advisory.util;

import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.model.domain.ChartInkScanRecord;
import tech.algofinserve.advisory.model.domain.Ticker;
@Component
public class ConversionUtil {

    public Ticker convertChartInkRecordToTicker(ChartInkScanRecord chartInkScanRecord){
        //Need to Revisit
        Ticker ticker=new Ticker();
        ticker.setStockCode(chartInkScanRecord.getStockName());
       ticker.setExchangeCode(chartInkScanRecord.getNseCode());

        return ticker;
    }


}
