package tech.algofinserve.advisory.processing;

import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.chartink.StockAlertRepository;
import tech.algofinserve.advisory.constants.BuySell;
import tech.algofinserve.advisory.model.domain.Alert;
import tech.algofinserve.advisory.model.domain.StockAlert;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Component
public class AlertProcessing {

    //Need to develop this class as multithreading

    public void processBuyAlert(Alert alert){



        String[] stocksName=alert.getStocks().split(",");
        String[] prices=alert.getTriggerPrices().split(",");

       for(int i=0;i<stocksName.length;i++){

           StockAlert stockAlert = convertAlertToStockAlert(alert, stocksName, prices,i);

           if(StockAlertRepository.stockAlertListForStockNameMap.containsKey(stockAlert.getStockCode())){
               StockAlertRepository.stockAlertListForStockNameMap.get(stockAlert.getStockCode()).add(stockAlert);
           }else{

               List<StockAlert> stockAlertList=new CopyOnWriteArrayList<>();
               stockAlertList.add(stockAlert);
               StockAlertRepository.stockAlertListForStockNameMap.put(stockAlert.getStockCode(),stockAlertList);
           }

           if(StockAlertRepository.stockAlertListForScanNameMap.containsKey(stockAlert.getScanName())){
               StockAlertRepository.stockAlertListForScanNameMap.get(stockAlert.getScanName()).add(stockAlert);
           }else{

               List<StockAlert> stockAlertList=new CopyOnWriteArrayList<>();
               stockAlertList.add(stockAlert);
               StockAlertRepository.stockAlertListForScanNameMap.put(stockAlert.getScanName(),stockAlertList);
           }

       }

    }

    private static StockAlert convertAlertToStockAlert(Alert alert,String[] stocksName, String[] prices, int i) {
        String scanName = alert.getScanName();
        String[] triggeredAt=alert.getTriggerdAt().split(":");
        String hour=triggeredAt[0];
        String[] minutes=triggeredAt[1].split(" ");

        Date triggeredDate=new Date();
        triggeredDate.setMinutes(Integer.parseInt(minutes[0]));

        if(minutes[1].equals("am")){
            triggeredDate.setHours(Integer.parseInt(hour));
        }else if(minutes[1].equals("pm")){
            triggeredDate.setHours(Integer.parseInt(hour + 12));
        }

        StockAlert stockAlert=new StockAlert();
        stockAlert.setBuySell(BuySell.BUY);
        stockAlert.setAlertDate(triggeredDate);
        stockAlert.setPrice(prices[i]);
        stockAlert.setStockCode(stocksName[i]);
        stockAlert.setScanName(scanName);
        return stockAlert;
    }

}
