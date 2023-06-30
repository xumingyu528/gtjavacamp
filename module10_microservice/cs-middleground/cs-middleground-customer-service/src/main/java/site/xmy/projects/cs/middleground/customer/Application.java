package site.xmy.projects.cs.middleground.customer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import site.xmy.projects.cs.middleground.customer.loadbalancer.CustomLoadBalancerConfig;
import site.xmy.projects.cs.middleground.customer.loadbalancer.RandomLoadBalancerConfig;

@SpringBootApplication(scanBasePackages = {"site.xmy.projects.cs"})
@MapperScan("site.xmy.projects.cs.middleground.customer.mapper")
@LoadBalancerClient(name = "integration-service", configuration = CustomLoadBalancerConfig.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
