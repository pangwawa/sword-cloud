package fun.codenow.sword.services.user;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2020/8/21 10:53
 **/
@Configuration
@EnableFeignClients(basePackages = {"fun.codenow.sword.services.user.feign"})
/*@ComponentScan(basePackages = "com.esdisplay.api.user.feign.factory")*/
public class ApiConfiguration {
}
