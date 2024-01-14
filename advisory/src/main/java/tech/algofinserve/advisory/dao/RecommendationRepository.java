package tech.algofinserve.advisory.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import tech.algofinserve.advisory.model.persistable.InstrumentTickerAngelPersistable;
import tech.algofinserve.advisory.model.persistable.RecommendationPersistable;

import java.util.List;

@Repository
public interface RecommendationRepository extends MongoRepository <RecommendationPersistable, Long> {


    @Query("{stockCode : ?0}")
    List<RecommendationPersistable> findRecommendationsByStockName(String stockCode);


}
