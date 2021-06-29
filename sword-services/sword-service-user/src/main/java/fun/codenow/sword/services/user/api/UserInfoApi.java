package fun.codenow.sword.services.user.api;

import com.google.gson.Gson;
import fun.codenow.sword.common.ResponseData;
import fun.codenow.sword.services.user.dto.UserInfoDTO;
import fun.codenow.sword.services.user.feign.IUserInfoApi;
import fun.codenow.sword.services.user.service.IAuthorInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/28 16:57
 **/
@RestController
@Slf4j
public class UserInfoApi implements IUserInfoApi {
    @Autowired
    IAuthorInfoService authorInfoService;
    @Override
    @GetMapping(value = "/userinfo/getuserinfobyid")
    public ResponseData<UserInfoDTO> getUserInfoById(Long authorId) {
        UserInfoDTO userInfoDTO= null;
        try {
            userInfoDTO = authorInfoService.getUserInfoByAuthorId(authorId);
        } catch (NullPointerException e) {
            return ResponseData.failed("该用户不存在");
        }
        log.info("user service getUserInfoById: result:{}",new Gson().toJson(userInfoDTO));
        return ResponseData.success(userInfoDTO,"获取用户信息成功");
    }
}
