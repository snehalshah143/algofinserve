package tech.algofinserve.advisory.core;

import tech.algofinserve.advisory.model.domain.Recommendation;

public abstract class StoplossCalculation {

    public abstract void calculateStoploss1(Recommendation recommendation);
    public abstract void calculateStoploss2(Recommendation recommendation);
    public abstract void calculateHardStoploss(Recommendation recommendation);
}
