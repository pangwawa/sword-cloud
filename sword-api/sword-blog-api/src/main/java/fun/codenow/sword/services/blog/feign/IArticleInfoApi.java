package fun.codenow.sword.services.blog.feign;

import fun.codenow.sword.common.ResponseData;
import fun.codenow.sword.common.model.PageVO;
import fun.codenow.sword.services.blog.feign.factory.ArticleInfoApiCallbackFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "sword-service-blog",contextId = "articleInfoApi",fallbackFactory = ArticleInfoApiCallbackFactory.class)
public interface IArticleInfoApi {
    @ApiOperation(value = "article信息列表分页查询")
    @GetMapping(value = "/api/article/list")
    ResponseData getArticleInfoList(Long authorId, PageVO pageVO);

    @ApiOperation(value = "article内容详情，根据articleId获取内容详情")
    @GetMapping(value = "/api/article/content")
    ResponseData getArticleContentById(Long articleId);
}
