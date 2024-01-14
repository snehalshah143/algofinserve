package tech.algofinserve.advisory.service;

import tech.algofinserve.advisory.model.domain.InstrumentTickerAngel;

import java.io.IOException;
import java.util.List;

public interface MetaDataService {

    public void loadInstrumentsTickerFromAPI();
    public void saveInstrumentTickerList(List<InstrumentTickerAngel> instrumentTickerAngelList);

    public List<InstrumentTickerAngel> getAllInstrumentTickerList();
    public InstrumentTickerAngel getInstrumentTickerForName(String tickerName);
    }
