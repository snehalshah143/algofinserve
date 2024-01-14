package tech.algofinserve.advisory.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.algofinserve.advisory.model.persistable.InstrumentTickerAngelPersistable;


@Repository
public interface InstrumentTickerAngelRepository extends MongoRepository<InstrumentTickerAngelPersistable, Long> {
}
