package tech.algofinserve.advisory.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.model.domain.Recommendation;
import tech.algofinserve.advisory.model.persistable.RecommendationPersistable;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-08T18:46:42+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 11.0.21 (Amazon.com Inc.)"
)
@Component
public class RecommendationMapperImpl implements RecommendationMapper {

    @Override
    public RecommendationPersistable mapDomainToPersistable(Recommendation recommendation) {
        if ( recommendation == null ) {
            return null;
        }

        RecommendationPersistable recommendationPersistable = new RecommendationPersistable();

        recommendationPersistable.setUpdatedDate( recommendation.getUpdatedDate() );
        recommendationPersistable.setUpdatedStatus( recommendation.getUpdatedStatus() );
        recommendationPersistable.setRecommendationId( recommendation.getRecommendationId() );
        recommendationPersistable.setBuySell( recommendation.getBuySell() );
        recommendationPersistable.setExchangeSegment( recommendation.getExchangeSegment() );
        recommendationPersistable.setInstrumentType( recommendation.getInstrumentType() );
        recommendationPersistable.setEntryPrice( recommendation.getEntryPrice() );
        List<String> list = recommendation.getTargets();
        if ( list != null ) {
            recommendationPersistable.setTargets( new ArrayList<String>( list ) );
        }
        recommendationPersistable.setStoploss1( recommendation.getStoploss1() );
        recommendationPersistable.setStoploss2( recommendation.getStoploss2() );
        recommendationPersistable.setHardStoploss( recommendation.getHardStoploss() );
        recommendationPersistable.setStockSymbol( recommendation.getStockSymbol() );
        recommendationPersistable.setRecommendationValidity( recommendation.getRecommendationValidity() );
        recommendationPersistable.setExpectedGain( recommendation.getExpectedGain() );
        recommendationPersistable.setExpectedGainInPercent( recommendation.getExpectedGainInPercent() );
        recommendationPersistable.setRecommendedBy( recommendation.getRecommendedBy() );
        recommendationPersistable.setScannerName( recommendation.getScannerName() );
        recommendationPersistable.setRecommendedDate( recommendation.getRecommendedDate() );
        recommendationPersistable.setActive( recommendation.getActive() );
        recommendationPersistable.setActualGain( recommendation.getActualGain() );
        recommendationPersistable.setActualGainInPercent( recommendation.getActualGainInPercent() );
        recommendationPersistable.setTicker( recommendation.getTicker() );

        return recommendationPersistable;
    }

    @Override
    public Recommendation mapPersistableToDomain(RecommendationPersistable recommendationPersistable) {
        if ( recommendationPersistable == null ) {
            return null;
        }

        Recommendation recommendation = new Recommendation();

        recommendation.setUpdatedDate( recommendationPersistable.getUpdatedDate() );
        recommendation.setUpdatedStatus( recommendationPersistable.getUpdatedStatus() );
        recommendation.setRecommendationId( recommendationPersistable.getRecommendationId() );
        recommendation.setBuySell( recommendationPersistable.getBuySell() );
        recommendation.setInstrumentType( recommendationPersistable.getInstrumentType() );
        recommendation.setExchangeSegment( recommendationPersistable.getExchangeSegment() );
        recommendation.setEntryPrice( recommendationPersistable.getEntryPrice() );
        List<String> list = recommendationPersistable.getTargets();
        if ( list != null ) {
            recommendation.setTargets( new ArrayList<String>( list ) );
        }
        recommendation.setStoploss1( recommendationPersistable.getStoploss1() );
        recommendation.setStoploss2( recommendationPersistable.getStoploss2() );
        recommendation.setHardStoploss( recommendationPersistable.getHardStoploss() );
        recommendation.setStockSymbol( recommendationPersistable.getStockSymbol() );
        recommendation.setExpectedGain( recommendationPersistable.getExpectedGain() );
        recommendation.setExpectedGainInPercent( recommendationPersistable.getExpectedGainInPercent() );
        recommendation.setRecommendedBy( recommendationPersistable.getRecommendedBy() );
        recommendation.setScannerName( recommendationPersistable.getScannerName() );
        recommendation.setRecommendedDate( recommendationPersistable.getRecommendedDate() );
        recommendation.setActive( recommendationPersistable.getActive() );
        recommendation.setActualGain( recommendationPersistable.getActualGain() );
        recommendation.setActualGainInPercent( recommendationPersistable.getActualGainInPercent() );
        recommendation.setRecommendationValidity( recommendationPersistable.getRecommendationValidity() );
        recommendation.setTicker( recommendationPersistable.getTicker() );

        return recommendation;
    }
}
