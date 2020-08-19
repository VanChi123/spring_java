package vn.fis.project.springbootfinaltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = "vn.fis.project.springbootdemo")
//@EnableJpaRepositories(value = "vn.fis.project.springbootdemo.repos")
//@EntityScan({"vn.fis.project.springbootdemo.entity"})
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

}
