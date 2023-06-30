package site.xmy.projects.cs;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication
@MapperScan("site.xmy.projects.cs.mapper")
public class CSApplication {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public RestTemplate restTemplate(HttpComponentsClientHttpRequestFactory httpRequestFactory){
        httpRequestFactory.setConnectionRequestTimeout(3000);

        return new RestTemplate(httpRequestFactory);
    }

    public static void main(String[] args) {
        SpringApplication.run(CSApplication.class, args);
        log.info("**************************************************");
        log.info("************* CUSTOMER SYSTEM START **************");
        log.info("**************************************************");
    }
}
