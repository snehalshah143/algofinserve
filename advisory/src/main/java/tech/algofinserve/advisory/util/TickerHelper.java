package tech.algofinserve.advisory.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.model.domain.InstrumentTickerAngel;
import tech.algofinserve.advisory.model.domain.Recommendation;
import tech.algofinserve.advisory.model.domain.Ticker;
import tech.algofinserve.advisory.service.MetaDataService;

@Component
public class TickerHelper {

    @Autowired
    MetaDataService metaDataService;
    public Ticker constructTickerFromRecommendation(Recommendation recommendation){
        Ticker ticker=new Ticker();
        ticker.setStockSymbol(recommendation.getStockSymbol());
        ticker.setExchangeSegment(recommendation.getExchangeSegment());
        ticker.setInstrumentType(recommendation.getInstrumentType());
        InstrumentTickerAngel instrumentTickerAngel= metaDataService
                .getInstrumentTickerForStockName(recommendation.getStockSymbol(),recommendation.getExchangeSegment());
        ticker.setToken(instrumentTickerAngel.getToken());
        return ticker;
    }
}
