package tech.algofinserve.advisory.chartink;

import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.model.domain.Ticker;

import java.util.ArrayList;
import java.util.List;

@Component
public class TotalStocksDataFactory {

    public static List<Ticker> allStockInformationList=new ArrayList<>();
    public static List<String> monthlyBaseStockList=new ArrayList<>();
    public static List<String> avoidStockListForIntraday=new ArrayList<>();
    public static List<String> avoidStockListForPositionalLongTerm=new ArrayList<>();



}
