package tech.algofinserve.advisory.model.domain;

import org.springframework.data.annotation.Id;
import tech.algofinserve.advisory.constants.CandleTimeFrame;

public class StockData15Min extends  StockData{

    public StockData15Min(){
super(CandleTimeFrame.FIFTEEN_MINUTE);
    }
/*    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/
}
