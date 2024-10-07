package shop.xiaoyishi.service;

<<<<<<< HEAD
import shop.xiaoyishi.vo.CollectVO;
=======
>>>>>>> af0e12bd043a253d8c6797b54bf608e6be2ff7ed
import shop.xiaoyishi.vo.CommodityVO;
import shop.xiaoyishi.vo.PostVO;

import java.util.List;

public interface CollectService {
    /**
     * 查询收藏数量
     */
    Integer countCollect(Long userId);

<<<<<<< HEAD
    List<CommodityVO> commodities(Long userId);

    List<PostVO> posts(Long userId);

    List<CollectVO> collectList(Long userId, Integer type);
=======
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
>>>>>>> af0e12bd043a253d8c6797b54bf608e6be2ff7ed
}
