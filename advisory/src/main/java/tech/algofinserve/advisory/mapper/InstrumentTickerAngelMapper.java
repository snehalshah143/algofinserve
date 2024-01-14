package tech.algofinserve.advisory.mapper;

import org.mapstruct.Mapper;
import tech.algofinserve.advisory.model.domain.InstrumentTickerAngel;
import tech.algofinserve.advisory.model.persistable.InstrumentTickerAngelPersistable;

@Mapper(componentModel = "spring")
public interface InstrumentTickerAngelMapper {

    InstrumentTickerAngelPersistable mapDomainToPersistable(InstrumentTickerAngel instrumentTickerAngel);
    InstrumentTickerAngel mapPersistableToDomain(InstrumentTickerAngelPersistable instrumentTickerAngelPersistable);
}
