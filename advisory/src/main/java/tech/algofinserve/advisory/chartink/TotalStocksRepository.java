package tech.algofinserve.advisory.chartink;

import tech.algofinserve.advisory.model.Recommendation;
import tech.algofinserve.advisory.model.Ticker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalStocksRepository {

  public static TotalStocksRepository totalStocksRepository=new TotalStocksRepository();
    private TotalStocksRepository(){

    }

    public static  TotalStocksRepository getTotalStocksRepositoryInstance() {
        return totalStocksRepository;
    }

    public static List<Ticker> monthlyBaseStockList=new ArrayList<>();
    public static Map<Ticker,List<Recommendation>> stockWiseRecommendationsList=new HashMap<>();
    public static Map<Ticker,List<Recommendation>> stockWiseInActiveRecommendationsList=new HashMap<>();
    public static List<Ticker> avoidStockList=new ArrayList<>();
    public static List<Ticker> getMonthlyBaseStockList() {
        return monthlyBaseStockList;
    }

    public static List<Ticker> getAvoidStockList() {
        return avoidStockList;
    }
}
