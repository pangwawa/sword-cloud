package fun.codenow.sword.services.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/26 11:35
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class SwordUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwordUserApplication.class,args);
    }
}
