package tech.algofinserve.advisory.core;

import tech.algofinserve.advisory.model.domain.Recommendation;

public abstract class StoplossCalculation {

    //For Intraday Max Risk 2-3 % , Target 1:2,1:3,1:4
    //If stoploss is greater than above range Deny recommendation saying risk reward not favorable
    public abstract void calculateStoploss1(Recommendation recommendation);
    public abstract void calculateStoploss2(Recommendation recommendation);
    public abstract void calculateHardStoploss(Recommendation recommendation);
}
