package fun.codenow.sword.services.blog.feign.factory;

import feign.hystrix.FallbackFactory;
import fun.codenow.sword.common.ResponseData;
import fun.codenow.sword.common.model.PageVO;
import fun.codenow.sword.services.blog.feign.IArticleInfoApi;
import org.springframework.stereotype.Component;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/7/2 14:32
 **/
@Component
public class ArticleInfoApiCallbackFactory implements FallbackFactory<IArticleInfoApi> {
    @Override
    public IArticleInfoApi create(Throwable throwable) {
        return new IArticleInfoApi() {
            @Override
            public ResponseData getArticleInfoList(Long authorId, PageVO pageVO) {
                return ResponseData.failed("接口调用失败，service: user ,interface: getArticleInfoList, params:authorId:"+authorId);
            }

            @Override
            public ResponseData getArticleContentById(Long articleId) {
                return ResponseData.failed("接口调用失败，service: user ,interface: getArticleContentById, params:articleId:"+articleId);
            }
        };
    }
}
