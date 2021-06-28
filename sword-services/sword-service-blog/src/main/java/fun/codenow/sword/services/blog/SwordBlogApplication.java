package fun.codenow.sword.services.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/26 13:43
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class SwordBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwordBlogApplication.class,args);
    }
}
