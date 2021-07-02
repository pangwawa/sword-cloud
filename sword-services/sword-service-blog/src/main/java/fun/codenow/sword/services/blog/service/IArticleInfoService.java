package fun.codenow.sword.services.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.codenow.sword.services.blog.dto.ArticleInfoDTO;
import fun.codenow.sword.services.blog.entity.ArticleInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jack Wu
 * @since 2021-07-02
 */
public interface IArticleInfoService extends IService<ArticleInfo> {

    Page<ArticleInfoDTO> getArticleInfoPageByAuthorId(Long authorId, long current, long size);
}
