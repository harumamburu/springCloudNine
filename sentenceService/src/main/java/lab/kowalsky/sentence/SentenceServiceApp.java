package lab.kowalsky.sentence;

import lab.kowalsky.sentence.client.loadbalancer.config.LoadBalancerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SentenceServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(SentenceServiceApp.class, args);
    }
}
