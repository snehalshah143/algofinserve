package tech.algofinserve.advisory.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import tech.algofinserve.advisory.model.persistable.InstrumentTickerAngelPersistable;

import java.util.List;


@Repository
public interface InstrumentTickerAngelRepository extends MongoRepository<InstrumentTickerAngelPersistable, Long> {

    @Query("{exchSeg : ?0}")
    List<InstrumentTickerAngelPersistable> findInstrumentTickerByExchangeSegment(String exchangeSegment);

}
