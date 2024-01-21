package tech.algofinserve.advisory.core;

import com.angelbroking.smartapi.SmartConnect;
import tech.algofinserve.advisory.model.domain.Recommendation;

public class IntradayStoplossCalculation extends StoplossCalculation{

    //For Intraday Maximu Stoploss has to be 1-3  % and target 5 to 10%

    @Override
    public void calculateStoploss1(Recommendation recommendation) {

    }

    @Override
    public void calculateStoploss2(Recommendation recommendation) {

    }

    @Override
    public void calculateHardStoploss(Recommendation recommendation) {

    }
}
