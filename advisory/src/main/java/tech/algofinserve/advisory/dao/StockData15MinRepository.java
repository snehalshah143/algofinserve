package tech.algofinserve.advisory.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.algofinserve.advisory.model.persistable.StockData15MinPersistable;
import tech.algofinserve.advisory.model.persistable.StockDataDailyPersistable;

@Repository
public interface StockData15MinRepository extends MongoRepository<StockData15MinPersistable, Long> {

}
