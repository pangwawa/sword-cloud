package fun.codenow.oss.autoconfigure;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2020/8/5 14:38
 **/
public class TencentCosService {
    public TencentCosProperties tencentCosProperties;
    public TencentCosService(){
    }
    public TencentCosService(TencentCosProperties tencentCosProperties){
        this.tencentCosProperties = tencentCosProperties;
    }
    public String queryConfig(){
        return tencentCosProperties.toString();
    }
}
