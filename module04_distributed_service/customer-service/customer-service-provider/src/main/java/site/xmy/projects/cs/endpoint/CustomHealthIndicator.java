package site.xmy.projects.cs.endpoint;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;


@Component
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {


        try {
            URL url = new URL("http://xumingyu.site/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int status = connection.getResponseCode();

            if (status >= 200 && status < 300) {
                return Health.up().withDetail("health check success by xmy : ",status).build();
            } else {

                return Health.down().withDetail("fail for health check, code is : ",status).build();
            }

//            return null;
        } catch (Exception e) {
            return Health.down(e).build();
//            e.printStackTrace();
        }
    }
}
