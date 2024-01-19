package tech.algofinserve.advisory.model.domain;

import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.indicators.KSTIndicator;
import org.ta4j.core.indicators.RSIIndicator;

public class KSTSignalIndicator extends EMAIndicator {

 public KSTSignalIndicator(KSTIndicator kstIndicator, int barCount){

     super(kstIndicator,barCount);
    }

}
