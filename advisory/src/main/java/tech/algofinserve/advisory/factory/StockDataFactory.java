package tech.algofinserve.advisory.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import tech.algofinserve.advisory.constants.CandleTimeFrame;
import tech.algofinserve.advisory.dao.StockData15MinRepository;
import tech.algofinserve.advisory.dao.StockDataDailyRepository;
import tech.algofinserve.advisory.model.domain.StockData;
import tech.algofinserve.advisory.model.domain.StockData15Min;
import tech.algofinserve.advisory.model.domain.StockDataDaily;

public class StockDataFactory {
@Autowired
static
StockData15MinRepository stockData15MinRepository;
@Autowired
static
StockDataDailyRepository stockDataDailyRepository;
    public static  StockData getStockDataObject(CandleTimeFrame candleTimeFrame){

        switch (candleTimeFrame) {
            case ONE_DAY:
                return new StockDataDaily();
            case FIFTEEN_MINUTE:
                return new StockData15Min();

            default:
                throw new IllegalArgumentException("Unknown channel "+candleTimeFrame);
        }
    }

    public static  Long getStockDataCandleNumber(CandleTimeFrame candleTimeFrame){

        switch (candleTimeFrame) {
            case ONE_DAY:
                return 1L;
            case FIFTEEN_MINUTE:
                return 2L;

            default:
                throw new IllegalArgumentException("Unknown channel "+candleTimeFrame);
        }
    }

    public static MongoRepository getStockDataRepository(CandleTimeFrame candleTimeFrame){

        switch (candleTimeFrame) {
            case ONE_DAY:
                return stockDataDailyRepository;
            case FIFTEEN_MINUTE:
                return stockData15MinRepository;

            default:
                throw new IllegalArgumentException("Unknown timeFrame "+candleTimeFrame);
        }
    }

}
