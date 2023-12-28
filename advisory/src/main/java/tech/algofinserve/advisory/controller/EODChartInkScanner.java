package tech.algofinserve.advisory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.infra.ChartInkInfra;
import tech.algofinserve.advisory.chartink.ScannerListFactory;
import tech.algofinserve.advisory.chartink.TotalStocksRepository;
import tech.algofinserve.advisory.model.domain.ChartInkScanRecord;
import tech.algofinserve.advisory.model.domain.Ticker;
import tech.algofinserve.advisory.util.ConversionUtil;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import static tech.algofinserve.advisory.constants.ScannerNames.Snehal_Monthly_BUY_Base_Stock_List;
@Component
public class EODChartInkScanner {

    @Autowired
    private ConversionUtil conversionUtil;
    @Autowired
    ChartInkInfra infra;
    @PostConstruct
   public void loadBaseStocks() throws IOException {

       Set<ChartInkScanRecord> chartInkRecords=
               infra.getStocksListForScannerCondition(ScannerListFactory.getAllScanClauseMap().get(Snehal_Monthly_BUY_Base_Stock_List));

       ArrayList<Ticker> tickerList= (ArrayList<Ticker>) chartInkRecords.stream().map(p->conversionUtil.convertChartInkRecordToTicker(p)).collect(Collectors.toList());
       TotalStocksRepository.allStockInformationList.addAll(tickerList);
        TotalStocksRepository.monthlyBaseStockList.addAll(chartInkRecords.stream().map(p->p.getNseCode()).collect(Collectors.toList()));


   }


}
