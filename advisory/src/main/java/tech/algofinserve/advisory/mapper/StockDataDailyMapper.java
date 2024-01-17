package tech.algofinserve.advisory.mapper;

import org.mapstruct.Mapper;
import tech.algofinserve.advisory.model.domain.StockDataDaily;
import tech.algofinserve.advisory.model.persistable.StockDataDailyPersistable;

@Mapper(componentModel = "spring")
public interface StockDataDailyMapper {

    StockDataDailyPersistable mapDomainToPersistable(StockDataDaily stockDataDaily);
    StockDataDaily mapPersistableToDomain(StockDataDailyPersistable stockDataDailyPersistable);
}
