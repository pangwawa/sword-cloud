package fun.codenow.sword.services.blog.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.codenow.sword.common.ResponseData;
import fun.codenow.sword.common.model.PageVO;
import fun.codenow.sword.services.blog.dto.ArticleInfoDTO;
import fun.codenow.sword.services.blog.service.IArticleInfoService;
import fun.codenow.sword.services.user.feign.IUserInfoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/28 16:29
 **/
@RestController
public class ArticleInfoApi {
    @Autowired
    IUserInfoApi userInfoApi;
    @Autowired
    IArticleInfoService articleInfoService;
    @GetMapping(value = "/api/bloginfo/list")
    public ResponseData articleInfoList(Long authorId, PageVO pageVO){
        Page<ArticleInfoDTO> articleInfoDTOList =articleInfoService.getArticleInfoPageByAuthorId(authorId,pageVO.getCurrent(),pageVO.getSize());
        return ResponseData.success(articleInfoDTOList,"根据作者id获取文章列表成功");
    }
}
