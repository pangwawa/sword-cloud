package fun.codenow.sword.services.blog.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2021/7/2 10:17
 **/
@Data
public class ArticleInfoDTO {
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
