package fun.codenow.sword.services.blog.service.impl;

import fun.codenow.sword.services.blog.entity.AuthorInfo;
import fun.codenow.sword.services.blog.mapper.AuthorInfoMapper;
import fun.codenow.sword.services.blog.service.IAuthorInfoService;
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
public class AuthorInfoServiceImpl extends ServiceImpl<AuthorInfoMapper, AuthorInfo> implements IAuthorInfoService {

}
