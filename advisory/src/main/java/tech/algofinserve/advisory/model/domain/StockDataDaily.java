package tech.algofinserve.advisory.model.domain;

import org.springframework.data.annotation.Id;
import tech.algofinserve.advisory.constants.CandleTimeFrame;

public class StockDataDaily extends  StockData{

    public StockDataDaily(){
super(CandleTimeFrame.ONE_DAY);
    }

}
