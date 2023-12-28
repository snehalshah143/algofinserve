package tech.algofinserve.advisory.infra;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.model.domain.ChartInkScanRecord;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Component
public class ChartInkInfra {

private static Connection  connection;
   public ChartInkInfra(){
      connection= ChartInkConnectionFactory.getChartInkConnection();
   }
   public Set<ChartInkScanRecord> getStocksListForScannerCondition(String condition) throws IOException {

      JSONObject chartinkScanResponseJsonObject = getStockListForScannerCondition( condition);
      JSONArray list= (JSONArray) chartinkScanResponseJsonObject.get("data");
      Set<ChartInkScanRecord> scanStocksRecords = convertJSONArrayToChartInkScanRecord(list);

      return scanStocksRecords;


   }



   private static Set<ChartInkScanRecord> convertJSONArrayToChartInkScanRecord(JSONArray list) throws JsonProcessingException {
      ObjectMapper mapper=new ObjectMapper();
      Set<ChartInkScanRecord> scanStocksRecords=new HashSet<>();
      for(int i = 0; i< list.length(); i++){
         JSONObject jsonObject1= (JSONObject) list.get(i);
         ChartInkScanRecord a = mapper.readValue(jsonObject1.toString(),ChartInkScanRecord.class);
         scanStocksRecords.add(a);
      }
      return scanStocksRecords;
   }

   private JSONObject getStockListForScannerCondition(String condition) throws IOException {
      Map<String,String> headerMap=new HashMap<>();
      headerMap.put("x-csrf-token", getxCsrfToken());
      Map<String,String> dataMap=new HashMap<>();
      dataMap.put("scan_clause", condition);
      Document resDoc = connection.headers(headerMap)
              .data(dataMap)
              .post();

      Node node= Jsoup.parse(resDoc.html()).getElementsByTag("body").get(0).childNodes().get(0);
      String outputReposne=  ((TextNode)node).getWholeText();
      JSONObject chartinkResponseJsonObject=new JSONObject(outputReposne);
      return chartinkResponseJsonObject;
   }

   public String getxCsrfToken() throws IOException {
      Document doc =connection.get();
      Document documentJsoup= Jsoup.parse(doc.html());
     // Elements elements= documentJsoup.getElementsByTag("meta");
      String xCsrfToken=documentJsoup.getElementsByTag("meta").stream()
              .filter(e->e.attr("name").equals("csrf-token")).map(p->p.attr("content"))
              .findFirst().get();
      System.out.println("Final===xcrfToken=value=: " +xCsrfToken);
      return xCsrfToken;
   }


}
