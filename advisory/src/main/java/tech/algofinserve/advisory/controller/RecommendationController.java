package tech.algofinserve.advisory.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.algofinserve.advisory.model.domain.Recommendation;

@RestController
public class RecommendationController {

    @PostMapping(path = "/recommend/stock", consumes = "application/json")
    public void recommendStock(@RequestBody Recommendation recommendation) {
        System.out.println(recommendation.toString());
        /*
         * ObjectMapper mapper=new ObjectMapper(); try { Alert a=mapper.readValue(alert,
         * Alert.class); System.out.println(a); } catch (JsonProcessingException e) { //
         * TODO Auto-generated catch block e.printStackTrace(); }
         */

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
