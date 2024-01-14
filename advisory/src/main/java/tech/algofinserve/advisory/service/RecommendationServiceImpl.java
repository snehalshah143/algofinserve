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

    private Map<Ticker, List<Recommendation>> stockWiseRecommendationsMap=new ConcurrentHashMap<>();

    @Autowired
    RecommendationRepository recommendationRepository;

    @Autowired
    RecommendationMapper recommendationMapper;
    @Autowired
    RecommendationHelper recommendationHelper;

    @Autowired
    TickerHelper tickerHelper;
public RecommendationPersistable saveRecommendation(Recommendation recommendation){
     recommendationHelper.buildRecommendationDomainEntity(recommendation);
    addRecommendation(tickerHelper.constructTickerFromRecommendation(recommendation),recommendation);
    RecommendationPersistable recommendationPersistable=recommendationMapper.mapDomainToPersistable(recommendation);
    return   recommendationRepository.save(recommendationPersistable);
}



    public Map<Ticker, List<Recommendation>> getAllRecommendations(){

        if(stockWiseRecommendationsMap.isEmpty()){
            List<Recommendation> allRecommendations= recommendationRepository.findAll().stream().map(p->recommendationMapper.mapPersistableToDomain(p)).collect(Collectors.toList());
            allRecommendations.stream().forEach(p->{
                Ticker ticker=tickerHelper.constructTickerFromRecommendation(p);

                addRecommendationToMap(ticker,p);
            });
        }

        return stockWiseRecommendationsMap;
    }

    public void addRecommendation(Ticker ticker,Recommendation recommendation){

        addRecommendationToMap(ticker, recommendation);
    }
    private void addRecommendationToMap(Ticker ticker, Recommendation recommendation) {
        if(stockWiseRecommendationsMap.containsKey(ticker)){
            stockWiseRecommendationsMap.get(ticker).add(recommendation);

        }else{
            List<Recommendation> recommendations=new ArrayList<>();
            recommendations.add(recommendation);
            stockWiseRecommendationsMap.put(ticker,recommendations);
        }
    }

    public List<Recommendation> getAllRecommendationsForStockName(Ticker ticker){
        if(!stockWiseRecommendationsMap.containsKey(ticker)){
            List<Recommendation> recommendationList=recommendationRepository.findRecommendationsByStockName(ticker.getStockCode())
                    .stream().map(p->recommendationMapper.mapPersistableToDomain(p)).collect(Collectors.toList());
            stockWiseRecommendationsMap.put(ticker,recommendationList);
        }
        return stockWiseRecommendationsMap.get(ticker);
    }

}
