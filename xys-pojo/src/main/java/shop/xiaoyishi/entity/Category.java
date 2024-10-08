package shop.xiaoyishi.entity;

import java.time.LocalDateTime;

public class Category {
    // 主键
    private long categoryId;
    // 父级分类id
    private long parentCategoryId;
    // 分类名
    private String categoryName;
    // 创建时间
    private LocalDateTime createTime;
    // 修改时间
    private LocalDateTime updateTime;
    // 0: 未删, 1: 删除
    private Integer isDeleted;
}
