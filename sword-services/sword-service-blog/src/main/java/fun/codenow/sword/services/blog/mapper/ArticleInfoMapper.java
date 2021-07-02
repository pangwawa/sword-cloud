package fun.codenow.sword.services.blog.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.codenow.sword.services.blog.dto.ArticleInfoDTO;
import fun.codenow.sword.services.blog.entity.ArticleInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jack Wu
 * @since 2021-07-02
 */
public interface ArticleInfoMapper extends BaseMapper<ArticleInfo> {
    Page<ArticleInfoDTO> getArticleInfoPageByAuthorId(Long authorId, @Param("page") Page<ArticleInfoDTO> page);
}
