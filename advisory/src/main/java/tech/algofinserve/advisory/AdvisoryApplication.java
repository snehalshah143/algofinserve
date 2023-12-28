package tech.algofinserve.advisory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"tech.algofinserve"})
public class AdvisoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvisoryApplication.class, args);
	}

}
