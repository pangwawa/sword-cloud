package fun.codenow.sword.services.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fun.codenow.sword.common.exceptions.ServiceException;
import fun.codenow.sword.services.user.dto.UserInfoDTO;
import fun.codenow.sword.services.user.entity.AuthorInfo;
import fun.codenow.sword.services.user.mapper.AuthorInfoMapper;
import fun.codenow.sword.services.user.service.IAuthorInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    AuthorInfoMapper authorInfoMapper;
    @Override
    public UserInfoDTO getUserInfoByAuthorId(Long authorId) {
        QueryWrapper<AuthorInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("author_id",authorId);
        AuthorInfo authorInfo=authorInfoMapper.selectOne(queryWrapper);
        if (authorInfo==null){
            throw new ServiceException();
        }
        UserInfoDTO userInfoDTO=new UserInfoDTO();
        userInfoDTO.setAuthorId(authorInfo.getAuthorId());
        userInfoDTO.setAuthorName(authorInfo.getAuthorName());
        userInfoDTO.setAvatarImg(authorInfo.getAvatarImg());
        userInfoDTO.setRole(authorInfo.getRole());
        userInfoDTO.setVipLevel(authorInfo.getVipLevel());
        userInfoDTO.setExpValue(authorInfo.getExpValue());
        userInfoDTO.setGmtCreate(authorInfo.getGmtCreate());
        userInfoDTO.setGmtModified(authorInfo.getGmtModified());
        return userInfoDTO;
    }
}
