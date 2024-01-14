package tech.algofinserve.advisory.service;

import tech.algofinserve.advisory.model.domain.Recommendation;
import tech.algofinserve.advisory.model.domain.Ticker;
import tech.algofinserve.advisory.model.persistable.RecommendationPersistable;

import java.util.List;
import java.util.Map;

public interface RecommendationService {

    RecommendationPersistable saveRecommendation(Recommendation recommendation);

    Map<String, List<Recommendation>> getAllRecommendations();
    void addRecommendation(String stockCode,Recommendation recommendation);
    List<Recommendation> getAllRecommendationsForStockName(String stockCode);



}
