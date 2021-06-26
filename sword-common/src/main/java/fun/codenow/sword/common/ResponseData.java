package fun.codenow.sword.common;

import fun.codenow.sword.common.constant.ResultStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/26 11:29
 **/
@ApiModel(value = "接口返回统一格式")
public class ResponseData<T> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "处理数据的状态码,-1:表示请求数据处理失败，0：表示请求处理成功")
    private int code=0;

    @ApiModelProperty(value = "服务器的反馈信息")
    private String message="";

    @ApiModelProperty(value = "返回的具体数据")
    private T data;
    public static <T> ResponseData<T> success() {
        return restResult(null, ResultStatus.SUCCESS, null);
    }

    public static <T> ResponseData<T> success(T data) {
        return restResult(data, ResultStatus.SUCCESS, null);
    }

    public static <T> ResponseData<T> success(T data, String msg) {
        return restResult(data, ResultStatus.SUCCESS, msg);
    }

    public static <T> ResponseData<T> failed() {
        return restResult(null, ResultStatus.FAIL, null);
    }

    public static <T> ResponseData<T> failed(String msg) {
        return restResult(null, ResultStatus.FAIL, msg);
    }

    public static <T> ResponseData<T> failed(T data) {
        return restResult(data, ResultStatus.FAIL, null);
    }

    public static <T> ResponseData<T> failed(T data, String msg) {
        return restResult(data, ResultStatus.FAIL, msg);
    }

    public static <T> ResponseData<T> restResult(T data, int code, String msg) {
        ResponseData<T> result = new ResponseData<T>();
        result.setCode(code);
        result.setData(data);
        result.setMessage(msg);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
