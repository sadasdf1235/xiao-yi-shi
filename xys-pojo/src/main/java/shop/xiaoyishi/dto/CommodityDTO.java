package shop.xiaoyishi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CommodityDTO {
    private Long userId;
    private Long categoryId;
    private String title;
    private String description;
    private BigDecimal price;
    private String location;
    private List<String> images;
}
