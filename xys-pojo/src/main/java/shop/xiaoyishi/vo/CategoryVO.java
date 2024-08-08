package shop.xiaoyishi.vo;

import lombok.Data;

@Data
public class CategoryVO {
    private Long id;
    private Long parentId;
    private String name;
}
