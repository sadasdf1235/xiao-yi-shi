package shop.xiaoyishi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CollectCPVO {
    private List<CommodityVO> commodities;
    private List<PostVO> posts;
}
