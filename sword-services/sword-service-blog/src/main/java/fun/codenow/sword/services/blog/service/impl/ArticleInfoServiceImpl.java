package fun.codenow.sword.services.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.codenow.sword.services.blog.dto.ArticleInfoDTO;
import fun.codenow.sword.services.blog.entity.ArticleInfo;
import fun.codenow.sword.services.blog.mapper.ArticleInfoMapper;
import fun.codenow.sword.services.blog.service.IArticleInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jack Wu
 * @since 2021-07-02
 */
@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements IArticleInfoService {
    @Autowired
    ArticleInfoMapper articleInfoMapper;
    @Override
    public Page<ArticleInfoDTO> getArticleInfoPageByAuthorId(Long authorId, long current, long size) {
        Page<ArticleInfoDTO> page=new Page<>();
        page.setSize(size);
        page.setCurrent(current);
        return articleInfoMapper.getArticleInfoPageByAuthorId(authorId,page);
    }
}
