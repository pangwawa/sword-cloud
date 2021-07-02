package fun.codenow.sword.common.model.dto;

import java.util.Map;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/7/2 13:53
 **/
public class ApiLogDTO {
    private String tranceId;
    private Long timestamp;
    private String requestPath;
    private String token;
    private Integer requestType;
    private Map<String,Object> params;

    public String getTranceId() {
        return tranceId;
    }

    public void setTranceId(String tranceId) {
        this.tranceId = tranceId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
