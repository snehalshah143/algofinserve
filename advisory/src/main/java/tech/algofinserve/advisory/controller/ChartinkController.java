package tech.algofinserve.advisory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.algofinserve.advisory.model.domain.Alert;
import tech.algofinserve.advisory.processing.AlertProcessing;

@RestController
public class ChartinkController {

    @Autowired
    private AlertProcessing alertProcessing;

    @PostMapping(path = "/BuyAlertHourly", consumes = "application/json")
    public void alertsReceived(@RequestBody Alert alert) {
        System.out.println(alert.toString());

        alertProcessing.processBuyAlert(alert);

    }


}