package shop.xiaoyishi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryVO {
    private Long id;
    private Long userId;
    private Integer type;
    private String title;
    private BigDecimal price;
    private List<String> images;
    private String avatar;
    private String username;
}
