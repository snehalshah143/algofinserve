package tech.algofinserve.advisory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import tech.algofinserve.advisory.chartink.ChartInkInfra;
import tech.algofinserve.advisory.chartink.ScannerListFactory;
import tech.algofinserve.advisory.chartink.TotalStocksRepository;
import tech.algofinserve.advisory.model.ChartInkScanRecord;
import tech.algofinserve.advisory.model.Ticker;
import tech.algofinserve.advisory.util.ConversionUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import static tech.algofinserve.advisory.chartink.ScannerNames.Snehal_Monthly_BUY_Base_Stock_List;

public class EODChartInkScanner {

    @Autowired
    private ConversionUtil conversionUtil;
    @Autowired
    ChartInkInfra infra;
   public void loadBaseStocks() throws IOException {

       Set<ChartInkScanRecord> chartInkRecords=
               infra.getStocksListForScannerCondition(ScannerListFactory.getAllScanClauseMap().get(Snehal_Monthly_BUY_Base_Stock_List));

       ArrayList<Ticker> tickerList= (ArrayList<Ticker>) chartInkRecords.stream().map(p->conversionUtil.convertChartInkRecordToTicker(p)).collect(Collectors.toList());
       TotalStocksRepository.monthlyBaseStockList.addAll(tickerList);

   }


}
