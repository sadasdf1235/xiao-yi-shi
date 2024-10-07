package shop.xiaoyishi.entity;

import java.time.LocalDateTime;

public class History {
    // 历史记录id
    private Long historyId;
    // 用户id
    private Long userId;
    private Long commodityId;
    // 评论id
    private Long postId;
    // 创建时间
    private LocalDateTime createTime;
    // 修改时间
    private LocalDateTime updateTime;
    // 0: 未删, 1: 删除
    private Integer isDeleted;
}
