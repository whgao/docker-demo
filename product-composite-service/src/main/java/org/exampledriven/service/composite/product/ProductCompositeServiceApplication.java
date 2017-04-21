package org.exampledriven.service.composite.product;

import org.exampledriven.client.product.ProductServiceFeignClient;
import org.exampledriven.client.review.ReviewServiceFeignClient;
//import com.netflix.hystrix.strategy.HystrixPlugins;
//
//import org.exampledriven.service.util.MDCHystrixConcurrencyStrategy;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = {ProductServiceFeignClient.class, ReviewServiceFeignClient.class})
@ComponentScan({
	"org.exampledriven.service.composite.product"
	, "org.exampledriven.client.product"
	, "org.exampledriven.client.review"
})
public class ProductCompositeServiceApplication {

//    private static final Logger LOG = LoggerFactory.getLogger(ProductCompositeServiceApplication.class);
//
//    @Value("${app.rabbitmq.host:localhost}")
//    private String rabbitMqHost;
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        LOG.info("Create RabbitMqCF for host: {}", rabbitMqHost);
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitMqHost);
//        return connectionFactory;
//    }

    public static void main(String[] args) {
//        LOG.info("Register MDCHystrixConcurrencyStrategy");
//        HystrixPlugins.getInstance().registerConcurrencyStrategy(new MDCHystrixConcurrencyStrategy());
        SpringApplication.run(ProductCompositeServiceApplication.class, args);
    }
}
