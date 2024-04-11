package fun.codenow.oss.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2020/8/4 17:10
 **/
@Configuration
@ConfigurationProperties(
        prefix = "esun.config.oss.tencent"
)
public class TencentCosProperties {
    private String secretId;
    private String secretKey;

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        return "EsunTencentCosProperties{" +
                "secretId='" + secretId + '\'' +
                ", secretKey='" + secretKey + '\'' +
                '}';
    }
}
