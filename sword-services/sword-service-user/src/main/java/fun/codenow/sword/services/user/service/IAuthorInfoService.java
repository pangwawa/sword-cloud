package fun.codenow.sword.services.user.service;

import fun.codenow.sword.services.user.dto.UserInfoDTO;
import fun.codenow.sword.services.user.entity.AuthorInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jack Wu
 * @since 2021-06-28
 */
public interface IAuthorInfoService extends IService<AuthorInfo> {

    UserInfoDTO getUserInfoByAuthorId(Long authorId);

}
