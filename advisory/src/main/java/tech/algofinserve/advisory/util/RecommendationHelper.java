package tech.algofinserve.advisory.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import tech.algofinserve.advisory.constants.ExchangeSegment;
import tech.algofinserve.advisory.model.domain.Recommendation;
import tech.algofinserve.advisory.constants.RecommendedBy;
import tech.algofinserve.advisory.model.domain.Ticker;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class RecommendationHelper {

    @Autowired
    TickerHelper tickerHelper;

    public void buildRecommendationDomainEntity(Recommendation recommendation){

        if(recommendation.getRecommendationId()==null){
            recommendation.setRecommendationId(recommendation.getStockSymbol()+recommendation.getRecommendationValidity().value()+System.currentTimeMillis());
        }

       if(recommendation.getTicker() ==null ){
           Ticker ticker=tickerHelper.constructTickerFromRecommendation(recommendation);
           recommendation.setTicker(ticker);
       }

        if(recommendation.getActive()==null){
            recommendation.setActive(true);
        }

        if(recommendation.getRecommendedBy()==null){
            recommendation.setRecommendedBy(RecommendedBy.SYSTEM);
        }


        if(recommendation.getRecommendedDate()==null){
            recommendation.setRecommendedDate(LocalDateTime.now());
        }
        if(recommendation.getExpectedGain()==null){
            Double maxTargetPrice= Double.valueOf(recommendation.getTargets().get(recommendation.getTargets().size()-1));
            Double expectedGain=maxTargetPrice - Double.valueOf(recommendation.getEntryPrice());
            recommendation.setExpectedGain(String.valueOf(expectedGain));
        }

        if(recommendation.getExpectedGainInPercent()==null){

            Double maxTargetPrice= Double.valueOf(recommendation.getTargets().get(recommendation.getTargets().size()-1));
            Double expectedGain=maxTargetPrice - Double.valueOf(recommendation.getEntryPrice());
            Double expectedGainPercent=expectedGain /Double.valueOf(recommendation.getEntryPrice())*100.0;

            recommendation.setExpectedGainInPercent(String.valueOf(expectedGainPercent));
        }

        if(recommendation.getExchangeSegment()==null){
            recommendation.setExchangeSegment(ExchangeSegment.NSE);
        }


    }
}
