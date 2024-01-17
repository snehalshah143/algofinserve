package tech.algofinserve.advisory.chartink;

import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.constants.ScannerName;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
@Component
public class ChartInkScannerListFactory {

private static String baseScannerForAllEligibleStocks="Snehal_BUY_Monthly_MULTIBAGGERBASE";
    private static Map<String,String> liveHoulyScanClauseMap=new HashMap<>();
    private static Map<ScannerName,String> liveDailyScanClauseMap=new HashMap<>();
    private static Map<ScannerName,String> liveWeeklyScanClauseMap=new HashMap<>();
    private static Map<ScannerName,String> liveMonthlyScanClauseMap=new HashMap<>();

    private static Map<ScannerName,String> allScanClauseMap=new HashMap<>();

    @PostConstruct
public void init(){
        loadScannerListPropertiesFile();
    }







    public void loadScannerListPropertiesFile()  {

        InputStream inputStream=getClass().getResourceAsStream("/scannerlist.properties");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(inputStream));

        String line;
        while (true){
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if(line.startsWith("#")){
                continue;
            }
        String[] arr= line.split(":");
            allScanClauseMap.put(ScannerName.valueOf(arr[0]),arr[1]);
    }
    }

    public static Map<ScannerName, String> getLiveWeeklyscanClauseMap() {

      if(liveWeeklyScanClauseMap==null){
          liveWeeklyScanClauseMap=new HashMap<>();

      }

      return liveWeeklyScanClauseMap;
    }

    public static Map<ScannerName, String> getLiveMonthlyScanClauseMap() {

        if(liveMonthlyScanClauseMap==null){
            liveMonthlyScanClauseMap=new HashMap<>();

        }

        return liveMonthlyScanClauseMap;
    }

    public static Map<ScannerName, String> getAllScanClauseMap() {

        if(allScanClauseMap==null){
            allScanClauseMap=new HashMap<>();

        }

        return allScanClauseMap;
    }

}
