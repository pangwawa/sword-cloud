package fun.codenow.sword.services.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/28 16:14
 **/
@Configuration
@MapperScan(value = "fun.codenow.sword.services.blog.mapper")
public class ApplicationConfig {
}
