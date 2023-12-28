package tech.algofinserve.advisory.chartink;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
@Component
public class ScannerListFactory {


    private static Map<String,String> liveHoulyScanClauseMap=new HashMap<>();
    private static Map<String,String> liveDailyScanClauseMap=new HashMap<>();
    private static Map<String,String> liveWeeklyScanClauseMap=new HashMap<>();
    private static Map<String,String> liveMonthlyScanClauseMap=new HashMap<>();

    private static Map<String,String> allScanClauseMap=new HashMap<>();

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
            allScanClauseMap.put(arr[0],arr[1]);
    }
    }

    public static Map<String, String> getLiveWeeklyscanClauseMap() {

      if(liveWeeklyScanClauseMap==null){
          liveWeeklyScanClauseMap=new HashMap<>();

      }

      return liveWeeklyScanClauseMap;
    }

    public static Map<String, String> getLiveMonthlyScanClauseMap() {

        if(liveMonthlyScanClauseMap==null){
            liveMonthlyScanClauseMap=new HashMap<>();

        }

        return liveMonthlyScanClauseMap;
    }

    public static Map<String, String> getAllScanClauseMap() {

        if(allScanClauseMap==null){
            allScanClauseMap=new HashMap<>();

        }

        return allScanClauseMap;
    }

}
