package shop.xiaoyishi.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class CommodityVO {
    private Long commodityId;

    private Long userId;

    private Long categoryId;

    private String userName;

    private String title;

    private String description;

    private String location;

    private BigDecimal price; // 注意：这里使用BigDecimal来存储货币值

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private List<String> images;

    private String avatar;
}
