package tech.algofinserve.advisory.service;

import tech.algofinserve.advisory.constants.ExchangeSegment;
import tech.algofinserve.advisory.model.domain.InstrumentTickerAngel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface MetaDataService {

    public void loadInstrumentsTickerFromAPI();
    public void saveInstrumentTickerList(List<InstrumentTickerAngel> instrumentTickerAngelList);


    public void deleteAllInstrumentTicker();
    public Map<String,InstrumentTickerAngel> getInstrumentTickerMapForExchangeSegment(ExchangeSegment exchangeSegment);
    public InstrumentTickerAngel getInstrumentTickerForStockName(String stockName, ExchangeSegment exchangeSegment);

    }
