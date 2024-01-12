package tech.algofinserve.advisory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan({"tech.algofinserve"})
public class AdvisoryApplication  {

	public static void main(String[] args) {
		SpringApplication.run(AdvisoryApplication.class, args);
	}

}
