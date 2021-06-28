package fun.codenow.sword.services.user.entity;

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
@ApiModel(value="CommentsInfo对象", description="")
public class CommentsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "文章ID")
    private Long articleId;

    @ApiModelProperty(value = "评论内容")
    private String comment;

    @ApiModelProperty(value = "评论者的ID")
    private Long authorId;

    @ApiModelProperty(value = "评论状态，1：正常，0删除")
    private Integer commentStatus;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;


}
