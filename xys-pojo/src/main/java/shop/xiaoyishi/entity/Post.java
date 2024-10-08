package shop.xiaoyishi.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {
    private Long postId;

    private Long userId;

    private String title;

    private String description;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDeleted; // 0: 未删, 1: 删除
}
