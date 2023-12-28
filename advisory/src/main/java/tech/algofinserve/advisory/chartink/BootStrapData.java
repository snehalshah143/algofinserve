package tech.algofinserve.advisory.chartink;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BootStrapData {

    @PostConstruct
    public void init(){
        System.out.println("Bootstrap init called");

    }
}
