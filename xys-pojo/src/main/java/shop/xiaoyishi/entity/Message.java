package shop.xiaoyishi.entity;

import java.time.LocalDateTime;

public class Message {
    private Long messageId;
    private Long senderId;
    private Long receiverId;
    private Integer messageType;
    private String content;
    private Integer status;
    // 创建时间
    private LocalDateTime createTime;
    // 修改时间
    private LocalDateTime updateTime;
    // 0: 未删, 1: 删除
    private Integer isDeleted;
}
