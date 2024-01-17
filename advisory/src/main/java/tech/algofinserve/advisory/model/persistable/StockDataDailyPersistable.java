package tech.algofinserve.advisory.model.persistable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tech.algofinserve.advisory.constants.CandleTimeFrame;

@Document(collection = "stock_data_daily")
public class StockDataDailyPersistable extends StockDataPersistable {
    public StockDataDailyPersistable() {super(CandleTimeFrame.ONE_DAY);}
  @Id
    private Long id;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

}
