package fun.codenow.sword.services.blog.service.impl;

import fun.codenow.sword.services.blog.entity.LikeInfo;
import fun.codenow.sword.services.blog.mapper.LikeInfoMapper;
import fun.codenow.sword.services.blog.service.ILikeInfoService;
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
public class LikeInfoServiceImpl extends ServiceImpl<LikeInfoMapper, LikeInfo> implements ILikeInfoService {

}
