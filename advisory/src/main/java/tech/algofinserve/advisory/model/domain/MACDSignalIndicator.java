package tech.algofinserve.advisory.model.domain;

import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.indicators.MACDIndicator;

public class MACDSignalIndicator extends EMAIndicator {

 public  MACDSignalIndicator(MACDIndicator macdIndicator,int barCount){

     super(macdIndicator,barCount);
    }

}
