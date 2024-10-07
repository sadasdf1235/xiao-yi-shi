package shop.xiaoyishi.service;

import shop.xiaoyishi.vo.CollectVO;
import shop.xiaoyishi.vo.CommodityVO;
import shop.xiaoyishi.vo.PostVO;

import java.util.List;

public interface CollectService {
    /**
     * 查询收藏数量
     */
    Integer countCollect(Long userId);

    List<CommodityVO> commodities(Long userId);

    List<PostVO> posts(Long userId);

    List<CollectVO> collectList(Long userId, Integer type);
}
