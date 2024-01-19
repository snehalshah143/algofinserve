package tech.algofinserve.advisory.model.domain;

import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.indicators.MACDIndicator;
import org.ta4j.core.indicators.RSIIndicator;

public class RSISignalIndicator extends EMAIndicator {

 public RSISignalIndicator(RSIIndicator rsiIndicator, int barCount){

     super(rsiIndicator,barCount);
    }

}
