package fun.codenow.sword.services.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jack Wu
 * @since 2021-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="AuthorInfo对象", description="")
public class AuthorInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "作者ID")
    private Long authorId;

    @ApiModelProperty(value = "作者名称")
    private String authorName;

    private String password;

    @ApiModelProperty(value = "临时密码")
    private String agipassword;

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
