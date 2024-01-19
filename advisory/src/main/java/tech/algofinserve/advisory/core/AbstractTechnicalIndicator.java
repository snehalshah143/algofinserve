package tech.algofinserve.advisory.core;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.indicators.MACDIndicator;
import org.ta4j.core.indicators.RSIIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;

import java.util.function.BiFunction;
import java.util.function.Function;

public class AbstractTechnicalIndicator {

    Function<BarSeries, ClosePriceIndicator> closePriceIndicatorFunction=(barseries)->new ClosePriceIndicator(barseries);



}
