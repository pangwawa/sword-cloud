package fun.codenow.sword.services.user.feign.factory;

import feign.hystrix.FallbackFactory;
import fun.codenow.sword.common.ResponseData;
import fun.codenow.sword.services.user.dto.UserInfoDTO;
import fun.codenow.sword.services.user.feign.IUserInfoApi;
import org.springframework.stereotype.Component;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/28 17:59
 **/
@Component
public class UserInfoApiFactory implements FallbackFactory<IUserInfoApi> {
    @Override
    public IUserInfoApi create(Throwable throwable) {
       return new IUserInfoApi() {
           @Override
           public ResponseData<UserInfoDTO> getUserInfoById(Long authorId) {
               return ResponseData.failed("接口调用失败，service: user ,interface: getUserInfoById, params:authorId:"+authorId);
           }
       };
    }
}
