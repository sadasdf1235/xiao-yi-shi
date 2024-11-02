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

    /**
     * 商品收藏列表
     */
    List<CommodityVO> commodities(Long userId);

    /**
     * 帖子收藏列表
     */
    List<PostVO> posts(Long userId);

    /**
     * 收藏列表
     */
    List<CollectVO> collectList(Long userId, Integer type);
}
