package tech.algofinserve.advisory.chartink;

import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.model.domain.StockAlert;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class StockAlertRepository {


    private StockAlertRepository(){

    }
    //scanName vrs stockAlert List
 public static  Map<String, List<StockAlert>> stockAlertListForScanNameMap=new ConcurrentHashMap<>();

    //StockName NSECDOE vrs stockAlert
 public static  Map<String, List<StockAlert>> stockAlertListForStockNameMap=new ConcurrentHashMap<>();


}
