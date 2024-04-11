package fun.codenow.oss.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2020/8/4 17:12
 **/
@Configuration
@ConfigurationProperties(
        prefix = "esun.config.oss"
)
public class ObjectStorageProperties {
    /**
     * OSS/COS/OBS
     */
    private String provider;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
