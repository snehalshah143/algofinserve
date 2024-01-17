package tech.algofinserve.advisory.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.algofinserve.advisory.model.persistable.RecommendationPersistable;
import tech.algofinserve.advisory.model.persistable.StockDataDailyPersistable;

@Repository
public interface StockDataDailyRepository extends MongoRepository<StockDataDailyPersistable, Long> {

}
