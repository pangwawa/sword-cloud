package fun.codenow.sword.services.user.feign;

import fun.codenow.sword.common.ResponseData;
import fun.codenow.sword.services.user.dto.UserInfoDTO;
import fun.codenow.sword.services.user.feign.factory.UserInfoApiFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/28 16:55
 **/
@FeignClient(name = "sword-service-user",contextId = "userInfoApi",fallbackFactory = UserInfoApiFactory.class)
public interface IUserInfoApi {
    @GetMapping(value = "/userinfo/getuserinfobyid")
    ResponseData<UserInfoDTO> getUserInfoById(@RequestParam(value = "authorId") Long authorId);
}
