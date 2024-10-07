package shop.xiaoyishi.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import shop.xiaoyishi.dto.CommodityDTO;
import shop.xiaoyishi.entity.Commodity;
import shop.xiaoyishi.vo.CommodityVO;

import java.util.List;

@Mapper
public interface CommodityMapper {
    /**
     * 根据用户id查询商品
     * @param userId
     * @return
     */
    @Select("SELECT c.*, u.username,u.avatar  \n" +
            "        FROM users u  \n" +
            "        INNER JOIN commodity c ON u.user_id = c.user_id where c.user_id = #{userId}")
    List<CommodityVO> getByUserId(Long userId);

    /**
     * 获取商品列表
     * @return
     */
    @Select("SELECT c.*, u.username, u.avatar  \n" +
            "        FROM users u  \n" +
            "        INNER JOIN commodity c ON u.user_id = c.user_id ")
    List<CommodityVO> getList();

    @Select("select c.image_url from commodity_images c where commodity_id = #{id}")
    List<String> getImagesById(Long id);

    void addCommodity(Commodity commodity);

    void addCommodityImages(@Param("images")List<String> images, @Param("id")Long id);

    @Select("select * from commodity where commodity_id = #{id}")
    Commodity getCommodity(Long commodityId);
}
