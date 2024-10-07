package shop.xiaoyishi.entity;

import java.time.LocalDateTime;

public class Comment {
    // 评论id
    private Long commentId;
    // 评论人id
    private Long userId;
    // 商品id
    private Long commodityId;
    // 帖子id
    private Long postId;
    // 评论内容
    private String content;
    // 创建时间
    private LocalDateTime createTime;
    // 修改时间
    private LocalDateTime updateTime;
    // 0: 未删, 1: 删除
    private Integer isDeleted;
}
