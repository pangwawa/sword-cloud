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
 * @since 2021-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ArticleInfo对象", description="")
public class ArticleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "文章ID")
    private Long articleId;

    @ApiModelProperty(value = "文章封面图片")
    private String abstractImg;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "文章简介")
    private String articleAbstract;

    @ApiModelProperty(value = "浏览量")
    private Long pv;

    @ApiModelProperty(value = "状态，0：删除，1,未发布（草稿）2，私有，3，已发布，4，被禁止传播")
    private Integer articleStatus;

    @ApiModelProperty(value = "作者ID")
    private Long authorId;

    @ApiModelProperty(value = "作者名称")
    private String authorName;

    @ApiModelProperty(value = "文章类型")
    private Integer type;

    @ApiModelProperty(value = "点赞数")
    private Long likeNum;

    @ApiModelProperty(value = "评论数")
    private Long commentsNum;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;


}
