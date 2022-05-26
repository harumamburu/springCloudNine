package lab.kowalsky.sentence.client.loadbalancer.config;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@LoadBalancerClients({
        @LoadBalancerClient(value = "word-service-adjective", configuration = LoadBalancerConfiguration.class),
        @LoadBalancerClient(value = "word-service-noun", configuration = LoadBalancerConfiguration.class)
})
public class WebClientConfiguration {

    @Bean
    @LoadBalanced
    public Feign.Builder loadBalancedWebClientBuilder() {
        return Feign.builder();
    }
}
