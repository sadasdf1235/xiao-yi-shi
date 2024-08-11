package shop.xiaoyishi.service;

import shop.xiaoyishi.vo.CommodityVO;
import shop.xiaoyishi.vo.PostVO;

import java.util.List;

public interface CollectService {
    /**
     * 查询收藏数量
     */
    Integer countCollect(Long userId);

    /**
     * 查询收藏的商品
     * @param id
     * @return
     */
    List<CommodityVO> collectCommodity(Long id);

    /**
     * 查询收藏的帖子
     * @param id
     * @return
     */
    List<PostVO> collectPost(Long id);
}
