package shop.xiaoyishi.entity;

import java.time.LocalDateTime;

public class Follow {
    private Long followId;
    private Long followerd;
    private Long followingId;
    // 创建时间
    private LocalDateTime createTime;
    // 修改时间
    private LocalDateTime updateTime;
    // 0: 未删, 1: 删除
    private Integer isDeleted;
}
