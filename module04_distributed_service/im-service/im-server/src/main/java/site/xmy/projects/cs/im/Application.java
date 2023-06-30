package site.xmy.projects.cs.im;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import site.xmy.projects.cs.im.server.Server;

@SpringBootApplication
@MapperScan("site.xmy.projects.cs.im.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        Server.start();
    }
}