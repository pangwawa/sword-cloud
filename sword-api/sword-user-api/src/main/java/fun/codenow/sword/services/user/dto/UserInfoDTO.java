package fun.codenow.sword.services.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/6/28 17:03
 **/
@Data
public class UserInfoDTO {
    @ApiModelProperty(value = "作者ID")
    private Long authorId;

    @ApiModelProperty(value = "作者名称")
    private String authorName;

    private String password;
    @ApiModelProperty(value = "头像图片")
    private String avatarImg;

    @ApiModelProperty(value = "用户角色")
    private String role;

    @ApiModelProperty(value = "特权级别")
    private Integer vipLevel;

    @ApiModelProperty(value = "经验值")
    private Integer expValue;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;
}
