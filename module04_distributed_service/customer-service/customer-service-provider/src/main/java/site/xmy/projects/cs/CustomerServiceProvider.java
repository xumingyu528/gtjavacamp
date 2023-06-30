package site.xmy.projects.cs;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("site.xmy.projects.cs.mapper")
public class CustomerServiceProvider {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceProvider.class, args);
        log.info("**************************************************");
        log.info("************* CUSTOMER SERVICE START **************");
        log.info("**************************************************");
    }
}
