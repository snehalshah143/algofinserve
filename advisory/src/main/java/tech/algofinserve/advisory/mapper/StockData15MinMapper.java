package tech.algofinserve.advisory.mapper;

import org.mapstruct.Mapper;
import tech.algofinserve.advisory.model.domain.StockData15Min;
import tech.algofinserve.advisory.model.domain.StockDataDaily;
import tech.algofinserve.advisory.model.persistable.StockData15MinPersistable;
import tech.algofinserve.advisory.model.persistable.StockDataDailyPersistable;

@Mapper(componentModel = "spring")
public interface StockData15MinMapper {

    StockData15MinPersistable mapDomainToPersistable(StockData15Min stockData15Min);
    StockData15Min mapPersistableToDomain(StockData15MinPersistable stockData15MinPersistable);
}
