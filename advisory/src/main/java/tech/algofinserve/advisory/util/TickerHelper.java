package tech.algofinserve.advisory.util;

import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.model.domain.Recommendation;
import tech.algofinserve.advisory.model.domain.Ticker;

@Component
public class TickerHelper {

    public Ticker constructTicker(Recommendation recommendation){
        Ticker ticker=new Ticker();

        return ticker;
    }
}
