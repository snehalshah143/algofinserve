package tech.algofinserve.advisory.chartink;


import tech.algofinserve.advisory.model.ChartInkScanRecord;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class ChartInkScrapper {




   public ChartInkScrapper(){

   }
    public static void main(String[] args) throws IOException {
        ChartInkScrapper chartInkScrapper=new ChartInkScrapper();
        ChartInkInfra infra=new ChartInkInfra();

        HashMap<String, Set<ChartInkScanRecord>> stocksForScannerMap=new HashMap<>();

        String chartInkScannerName="snehal-monthly-buy-simple-strong";
        String conditionScannerName="( {cash} ( ( {cash} ( ( {cash} ( monthly ema( monthly close , 21 ) > monthly ema( monthly close , 55 ) and monthly ema( monthly close , 13 ) > monthly ema( monthly close , 55 ) and monthly close > monthly ema( monthly close , 34 ) and monthly rsi( 14 ) > 60 and monthly macd line( 22 , 10 , 7 ) > 0 and latest close > weekly ichimoku cloud top( 9 , 26 , 52 ) and weekly close > weekly ema( weekly close , 200 ) ) ) and( {cash} ( latest close > 20 and market cap > 100 ) ) ) ) ) )";

        stocksForScannerMap.put(chartInkScannerName,infra.getStocksListForScannerCondition(conditionScannerName));
    }


}
