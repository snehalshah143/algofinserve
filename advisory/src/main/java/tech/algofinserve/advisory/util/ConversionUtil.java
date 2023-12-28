package tech.algofinserve.advisory.util;

import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.model.domain.ChartInkScanRecord;
import tech.algofinserve.advisory.model.domain.Ticker;
@Component
public class ConversionUtil {

    public Ticker convertChartInkRecordToTicker(ChartInkScanRecord chartInkScanRecord){
        Ticker ticker=new Ticker();
        ticker.setStockName(chartInkScanRecord.getStockName());
        ticker.setNseCode(chartInkScanRecord.getNseCode());
        ticker.setBseCode(chartInkScanRecord.getBseCode());
        return ticker;
    }
}
