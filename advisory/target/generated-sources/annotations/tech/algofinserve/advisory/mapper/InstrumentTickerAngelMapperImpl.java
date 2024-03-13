package tech.algofinserve.advisory.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.model.domain.InstrumentTickerAngel;
import tech.algofinserve.advisory.model.persistable.InstrumentTickerAngelPersistable;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-26T22:58:03+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 11.0.21 (Amazon.com Inc.)"
)
@Component
public class InstrumentTickerAngelMapperImpl implements InstrumentTickerAngelMapper {

    @Override
    public InstrumentTickerAngelPersistable mapDomainToPersistable(InstrumentTickerAngel instrumentTickerAngel) {
        if ( instrumentTickerAngel == null ) {
            return null;
        }

        InstrumentTickerAngelPersistable instrumentTickerAngelPersistable = new InstrumentTickerAngelPersistable();

        instrumentTickerAngelPersistable.setExpiry( instrumentTickerAngel.getExpiry() );
        instrumentTickerAngelPersistable.setStrike( instrumentTickerAngel.getStrike() );
        instrumentTickerAngelPersistable.setLotsize( instrumentTickerAngel.getLotsize() );
        instrumentTickerAngelPersistable.setInstrumenttype( instrumentTickerAngel.getInstrumenttype() );
        instrumentTickerAngelPersistable.setExchSeg( instrumentTickerAngel.getExchSeg() );
        instrumentTickerAngelPersistable.setTickSize( instrumentTickerAngel.getTickSize() );
        instrumentTickerAngelPersistable.setToken( instrumentTickerAngel.getToken() );
        instrumentTickerAngelPersistable.setSymbol( instrumentTickerAngel.getSymbol() );
        instrumentTickerAngelPersistable.setName( instrumentTickerAngel.getName() );

        return instrumentTickerAngelPersistable;
    }

    @Override
    public InstrumentTickerAngel mapPersistableToDomain(InstrumentTickerAngelPersistable instrumentTickerAngelPersistable) {
        if ( instrumentTickerAngelPersistable == null ) {
            return null;
        }

        InstrumentTickerAngel instrumentTickerAngel = new InstrumentTickerAngel();

        instrumentTickerAngel.setExpiry( instrumentTickerAngelPersistable.getExpiry() );
        instrumentTickerAngel.setStrike( instrumentTickerAngelPersistable.getStrike() );
        instrumentTickerAngel.setLotsize( instrumentTickerAngelPersistable.getLotsize() );
        instrumentTickerAngel.setInstrumenttype( instrumentTickerAngelPersistable.getInstrumenttype() );
        instrumentTickerAngel.setExchSeg( instrumentTickerAngelPersistable.getExchSeg() );
        instrumentTickerAngel.setTickSize( instrumentTickerAngelPersistable.getTickSize() );
        instrumentTickerAngel.setToken( instrumentTickerAngelPersistable.getToken() );
        instrumentTickerAngel.setSymbol( instrumentTickerAngelPersistable.getSymbol() );
        instrumentTickerAngel.setName( instrumentTickerAngelPersistable.getName() );

        return instrumentTickerAngel;
    }
}
