package shop.xiaoyishi.entity;

import java.time.LocalDateTime;

public class Collect {
    private Long collectionId;
    private Long userId;
    private Long commodityId;
    private Long postId;
    private Integer isDeleted;
    // 创建时间
    private LocalDateTime createTime;
    // 修改时间
    private LocalDateTime updateTime;
}
