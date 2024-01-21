package tech.algofinserve.advisory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.algofinserve.advisory.model.domain.Recommendation;
import tech.algofinserve.advisory.model.persistable.RecommendationPersistable;
import tech.algofinserve.advisory.service.RecommendationService;

@RestController
public class RecommendationController {

    @Autowired
    RecommendationService recommendationService;


    @PostMapping(path = "/advisory/recommend/stock", consumes = "application/json")
    public ResponseEntity<String> recommendStock(@RequestBody Recommendation recommendation) {
        RecommendationPersistable recommendationPersistable= recommendationService.saveRecommendation(recommendation);

        return new ResponseEntity<String>("Recommendation Published Successfully for ID::"+recommendationPersistable.getRecommendationId(), HttpStatus.OK);

    }

    @PostMapping(path = "/recommend/update", consumes = "application/json")
    public void recommendUpdate(@RequestBody Recommendation recommendationUpdate) {
        System.out.println(recommendationUpdate.toString());
        /*
         * ObjectMapper mapper=new ObjectMapper(); try { Alert a=mapper.readValue(alert,
         * Alert.class); System.out.println(a); } catch (JsonProcessingException e) { //
         * TODO Auto-generated catch block e.printStackTrace(); }
         */

    }
}
