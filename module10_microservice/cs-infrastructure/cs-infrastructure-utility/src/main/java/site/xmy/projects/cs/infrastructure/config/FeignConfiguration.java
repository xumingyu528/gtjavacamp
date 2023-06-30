package site.xmy.projects.cs.infrastructure.config;

import feign.Logger;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"site.xmy.projects.cs.*"})
public class FeignConfiguration {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    @Bean
    FeignErrorDecoder errorDecoder(){
        return new FeignErrorDecoder();
    }
}
