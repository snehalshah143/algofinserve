package tech.algofinserve.advisory.chartink;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.model.domain.Recommendation;
import tech.algofinserve.advisory.model.domain.Ticker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class RecommendationsFactory {

    public static Map<Ticker, List<Recommendation>> stockWiseRecommendationsList=new HashMap<>();
    public static Map<Ticker,List<Recommendation>> stockWiseInActiveRecommendationsList=new HashMap<>();

}
