package tech.algofinserve.advisory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.algofinserve.advisory.dao.RecommendationRepository;
import tech.algofinserve.advisory.mapper.RecommendationMapper;
import tech.algofinserve.advisory.model.domain.Recommendation;
import tech.algofinserve.advisory.model.domain.Ticker;
import tech.algofinserve.advisory.model.persistable.RecommendationPersistable;
import tech.algofinserve.advisory.util.RecommendationHelper;
import tech.algofinserve.advisory.util.TickerHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService{

    private Map<String, List<Recommendation>> stockWiseRecommendationsMap=new ConcurrentHashMap<>();

    @Autowired
    RecommendationRepository recommendationRepository;

    @Autowired
    RecommendationMapper recommendationMapper;
    @Autowired
    RecommendationHelper recommendationHelper;

public RecommendationPersistable saveRecommendation(Recommendation recommendation){

     recommendationHelper.buildRecommendationDomainEntity(recommendation);
    addRecommendationLocalCache(recommendation.getStockSymbol(),recommendation);
    RecommendationPersistable recommendationPersistable=recommendationMapper.mapDomainToPersistable(recommendation);
    return   recommendationRepository.save(recommendationPersistable);
}



    public Map<String, List<Recommendation>> getAllRecommendations(){

        if(stockWiseRecommendationsMap.isEmpty()){
            List<Recommendation> allRecommendations= recommendationRepository.findAll().stream().map(p->recommendationMapper.mapPersistableToDomain(p)).collect(Collectors.toList());
            allRecommendations.stream().forEach(p->{

                addRecommendationToMap(p.getStockSymbol(),p);
            });
        }

        return stockWiseRecommendationsMap;
    }

    public void addRecommendationLocalCache(String stockCode,Recommendation recommendation){

        addRecommendationToMap(stockCode, recommendation);
    }
    private void addRecommendationToMap(String stockCode, Recommendation recommendation) {
        if(stockWiseRecommendationsMap.containsKey(stockCode)){
            stockWiseRecommendationsMap.get(stockCode).add(recommendation);

        }else{
            List<Recommendation> recommendations=new ArrayList<>();
            recommendations.add(recommendation);
            stockWiseRecommendationsMap.put(stockCode,recommendations);
        }
    }

    public List<Recommendation> getAllRecommendationsForStockName(String stockCode){
        if(!stockWiseRecommendationsMap.containsKey(stockCode)){
            List<Recommendation> recommendationList=recommendationRepository.findRecommendationsByStockName(stockCode)
                    .stream().map(p->recommendationMapper.mapPersistableToDomain(p)).collect(Collectors.toList());
            stockWiseRecommendationsMap.put(stockCode,recommendationList);
        }
        return stockWiseRecommendationsMap.get(stockCode);
    }

}
