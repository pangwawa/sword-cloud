package fun.codenow.sword.services.blog.service.impl;

import fun.codenow.sword.services.blog.entity.CommentsInfo;
import fun.codenow.sword.services.blog.mapper.CommentsInfoMapper;
import fun.codenow.sword.services.blog.service.ICommentsInfoService;
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
public class CommentsInfoServiceImpl extends ServiceImpl<CommentsInfoMapper, CommentsInfo> implements ICommentsInfoService {

}
