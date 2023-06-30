package site.xmy.hangzhou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaAuditing
public class HangzhouCustomerApplication {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(HangzhouCustomerApplication.class,args);
    }
}
