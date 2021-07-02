package fun.codenow.sword.services.blog.handler;

import fun.codenow.sword.common.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/7/2 15:28
 **/
@ControllerAdvice
@Slf4j
public class SwordExceptionHandler {
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseData handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        exception.getBindingResult().getAllErrors();
        Iterator errorIterator = exception.getBindingResult().getAllErrors().iterator();
        StringBuilder errorInfo =new StringBuilder();
        while(errorIterator.hasNext()) {
            ObjectError error = (ObjectError)errorIterator.next();
            errorInfo.append(error.getDefaultMessage()+" ");
        }
        log.error("请求参数错误handleMethodArgumentNotValidException:{}",errorInfo);
        return ResponseData.failed(errorInfo,"参数校验失败");
    }
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseData handleException(Exception exception){
        log.error("请求报错(handleException):{},message{},cause:{}",exception.getClass(),exception.getMessage(),exception.getCause());
        return ResponseData.failed("error message: "+exception.getMessage()+",error cause: "+exception.getCause(),"请求出错，"+exception.getMessage());
    }
}
