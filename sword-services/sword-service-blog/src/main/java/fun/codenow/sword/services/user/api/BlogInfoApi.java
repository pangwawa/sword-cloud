package fun.codenow.sword.services.user.api;

import fun.codenow.sword.common.ResponseData;
import fun.codenow.sword.services.user.dto.UserInfoDTO;
import fun.codenow.sword.services.user.feign.IUserInfoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/28 16:29
 **/
@RestController
public class BlogInfoApi {
    @Autowired
    IUserInfoApi userInfoApi;
    @GetMapping(value = "/api/bloginfo/list")
    public ResponseData testApi(Long authorId){
        UserInfoDTO userInfoDTO= userInfoApi.getUserInfoById(authorId).getData();
        /*throw new RuntimeException("异常测试"); */
        return ResponseData.success(userInfoDTO,"根据作者id获取文章列表成功");
    }
}
