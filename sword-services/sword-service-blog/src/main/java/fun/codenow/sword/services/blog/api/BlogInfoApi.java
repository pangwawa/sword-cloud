package fun.codenow.sword.services.blog.api;

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
    @GetMapping(value = "/api/bloginfo/test")
    public Object testApi(){
        return "blog info test";
    }
}
