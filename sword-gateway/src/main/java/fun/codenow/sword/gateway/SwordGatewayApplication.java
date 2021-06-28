package fun.codenow.sword.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/26 11:30
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class SwordGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwordGatewayApplication.class,args);
    }
}
