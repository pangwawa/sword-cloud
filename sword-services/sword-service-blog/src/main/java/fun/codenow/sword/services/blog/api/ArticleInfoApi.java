package fun.codenow.sword.services.blog.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.codenow.sword.common.ResponseData;
import fun.codenow.sword.common.model.PageVO;
import fun.codenow.sword.services.blog.dto.ArticleInfoDTO;
import fun.codenow.sword.services.blog.feign.IArticleInfoApi;
import fun.codenow.sword.services.blog.service.IArticleInfoService;
import fun.codenow.sword.services.user.feign.IUserInfoApi;
import io.swagger.annotations.ApiOperation;
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
public class ArticleInfoApi implements IArticleInfoApi {
    @Autowired
    IUserInfoApi userInfoApi;
    @Autowired
    IArticleInfoService articleInfoService;
    @Override
    @ApiOperation(value = "article信息列表分页查询")
    @GetMapping(value = "/api/article/list")
    public ResponseData<Page<ArticleInfoDTO>> getArticleInfoList(Long authorId, PageVO pageVO){
        Page<ArticleInfoDTO> articleInfoDTOList =articleInfoService.getArticleInfoPageByAuthorId(authorId,pageVO.getCurrent(),pageVO.getSize());
        return ResponseData.success(articleInfoDTOList,"根据作者id获取文章列表成功");
    }

    @ApiOperation(value = "article内容详情，根据articleId获取内容详情")
    @GetMapping(value = "/api/article/content")
    @Override
    public ResponseData getArticleContentById(Long articleId){
        return ResponseData.success();
    }
}
