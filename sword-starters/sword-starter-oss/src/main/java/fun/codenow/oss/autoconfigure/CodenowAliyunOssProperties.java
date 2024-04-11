package fun.codenow.oss.autoconfigure;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2020/8/4 10:36
 **/
@Configuration
@ConfigurationProperties(
        prefix = "esun.config.oss.aliyun"
)
public class CodenowAliyunOssProperties {
    /**
     * 访问域
     */
    private String endpoint;
    /**
     *  AccessKeyId 和 AccessKeySecret 的统称，访问密钥
     */
    private String accessKeyId;

    private String accessKeySecret;
    /**
     * 存储空间名称
     */
    private String bucketName;
    /**
     *  自定义的访问路径
     */
    private String baseUrl;

    /**
     *  oss 签名使用的dir
     */
    private String dir;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "EsunAliyunOssProperties{" +
                "endpoint='" + endpoint + '\'' +
                ", accessKeyId='" + accessKeyId + '\'' +
                ", accessKeySecret='" + accessKeySecret + '\'' +
                ", bucketName='" + bucketName + '\'' +
                ", baseUrl='" + baseUrl + '\'' +
                '}';
    }
}
