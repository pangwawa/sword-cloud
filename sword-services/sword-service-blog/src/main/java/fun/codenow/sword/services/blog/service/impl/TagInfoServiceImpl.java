package fun.codenow.sword.services.blog.service.impl;

import fun.codenow.sword.services.blog.entity.TagInfo;
import fun.codenow.sword.services.blog.mapper.TagInfoMapper;
import fun.codenow.sword.services.blog.service.ITagInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jack Wu
 * @since 2021-06-28
 */
@Service
public class TagInfoServiceImpl extends ServiceImpl<TagInfoMapper, TagInfo> implements ITagInfoService {

}
