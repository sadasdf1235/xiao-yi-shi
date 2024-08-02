package shop.xiaoyishi.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PostVO {
    private Long postId;

    private Long userId;

    private String userName;

    private String avatar;

    private String title;

    private String description;

    private Long likes;

    private Long fans;

    private Long messages;

    private List<String> images;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
