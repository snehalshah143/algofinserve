package tech.algofinserve.advisory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.chartink.AllStocksDataFactory;
import tech.algofinserve.advisory.chartink.ChartInkScannerListFactory;
import tech.algofinserve.advisory.constants.ScannerName;
import tech.algofinserve.advisory.infra.ChartInkInfra;
import tech.algofinserve.advisory.model.domain.ChartInkScanRecord;
import tech.algofinserve.advisory.model.domain.Ticker;
import tech.algofinserve.advisory.util.ConversionUtil;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class EODChartInkScanner {

    @Autowired
    private ConversionUtil conversionUtil;
    @Autowired
    ChartInkInfra infra;
    @PostConstruct
   public void loadBaseStocks() throws IOException {

       Set<ChartInkScanRecord> chartInkRecords=
               infra.getStocksListForScannerCondition(ChartInkScannerListFactory.getAllScanClauseMap().get(ScannerName.Snehal_BUY_Monthly_MULTIBAGGERBASE));

       ArrayList<Ticker> tickerList= (ArrayList<Ticker>) chartInkRecords.stream().map(p->conversionUtil.convertChartInkRecordToTicker(p)).collect(Collectors.toList());
       AllStocksDataFactory.allStockInformationList.addAll(tickerList);
        AllStocksDataFactory.monthlyBaseStockList.addAll(chartInkRecords.stream().map(p->p.getNseCode()).collect(Collectors.toList()));


   }


}
