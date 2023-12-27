package tech.algofinserve.advisory.util;

import tech.algofinserve.advisory.model.ChartInkScanRecord;
import tech.algofinserve.advisory.model.Ticker;

public class ConversionUtil {

    public Ticker convertChartInkRecordToTicker(ChartInkScanRecord chartInkScanRecord){
        Ticker ticker=new Ticker();
        ticker.setStockName(chartInkScanRecord.getStockName());
        ticker.setNseCode(chartInkScanRecord.getNseCode());
        ticker.setBseCode(chartInkScanRecord.getBseCode());
        return ticker;
    }
}
