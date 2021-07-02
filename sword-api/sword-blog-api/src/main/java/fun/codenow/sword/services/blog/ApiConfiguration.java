package fun.codenow.sword.services.blog;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/7/2 14:42
 **/
@Configuration
@EnableFeignClients(basePackages = {"fun.codenow.sword.services.blog.feign"})
public class ApiConfiguration {
}
