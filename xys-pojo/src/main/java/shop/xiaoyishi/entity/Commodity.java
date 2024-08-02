package shop.xiaoyishi.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商品表
 */
@Data
public class Commodity {
    private Long commodityId;

    private Long userId;

    private Long categoryId;

    private String title;

    private String description;

    private String location;

    private BigDecimal price; // 注意：这里使用BigDecimal来存储货币值

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDeleted;
}
