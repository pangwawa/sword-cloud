package fun.codenow.oss.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2020/8/4 10:35
 **/
@Configuration
@EnableConfigurationProperties({CodenowAliyunOssProperties.class, TencentCosProperties.class})
public class ObjectStorageAutoConfiguration {
    @Autowired
    private CodenowAliyunOssProperties codenowAliyunOssProperties;
    @Autowired
    private TencentCosProperties tencentCosProperties;
    public ObjectStorageAutoConfiguration(){

    }

    @Bean
    @ConditionalOnProperty(value = "esun.config.oss.provider",havingValue = "OSS")
    public AliyunOssService aliyunOssService(){
        return new AliyunOssService(codenowAliyunOssProperties);
    }

    @Bean
    @ConditionalOnProperty(value = "esun.config.oss.provider",havingValue = "COS")
    public TencentCosService tencentCosService(){
        return new TencentCosService(tencentCosProperties);
    }
}
