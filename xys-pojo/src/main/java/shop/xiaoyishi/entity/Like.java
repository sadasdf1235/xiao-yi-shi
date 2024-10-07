package shop.xiaoyishi.entity;

import java.time.LocalDateTime;

public class Like {
    // 主键
    private Long likeId;
    // 用户id
    private Long userId;
    private Long commodityId;
    // 帖子id
    private Long postId;// 创建时间
    private LocalDateTime createTime;
    // 修改时间
    private LocalDateTime updateTime;
    // 0: 未删, 1: 删除
    private Integer isDeleted;
}
