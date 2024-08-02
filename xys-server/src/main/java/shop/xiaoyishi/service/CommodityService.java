package shop.xiaoyishi.service;

import shop.xiaoyishi.entity.Commodity;
import shop.xiaoyishi.vo.CommodityVO;

import java.util.List;

public interface CommodityService {
    /**
     * 根据用户id查询商品
     * @param userId
     * @return
     */
    List<CommodityVO> getByUserId(Long userId);

    /**
     * 获取商品列表
     * @return
     */
    List<CommodityVO> getList();
}
