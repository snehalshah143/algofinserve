package tech.algofinserve.advisory.model.persistable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tech.algofinserve.advisory.constants.CandleTimeFrame;
import tech.algofinserve.advisory.constants.ExchangeSegment;
import tech.algofinserve.advisory.constants.InstrumentType;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "stock_data_15min")
public class StockData15MinPersistable extends StockDataPersistable {
    public StockData15MinPersistable() {super(CandleTimeFrame.FIFTEEN_MINUTE);}


}
