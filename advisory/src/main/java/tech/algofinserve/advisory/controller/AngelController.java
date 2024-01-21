package tech.algofinserve.advisory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.algofinserve.advisory.model.domain.Recommendation;
import tech.algofinserve.advisory.service.MetaDataService;

import java.util.Set;

@RestController
public class AngelController {
    @Autowired
    private MetaDataService metaDataService;

    @PostMapping(path = "/setup/angel/loadAllInstrumentTickerFromAPI")
    public ResponseEntity<String> loadInstrumentTickerFromAPI() {
        metaDataService.loadInstrumentsTickerFromAPI();
        return new ResponseEntity<String>("Instrument Ticker Loading Completed.", HttpStatus.OK);

    }

    @GetMapping(path = "/setup/angel/getAllSymbols")
    public ResponseEntity<Set<String>> getAllChartInkSymbolList() {
       Set<String> allSymbols= metaDataService.getAllChartInkSymbolList();
        return new ResponseEntity<Set<String>>(allSymbols, HttpStatus.OK);

    }



}
