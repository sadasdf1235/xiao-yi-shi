package shop.xiaoyishi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
            "        INNER JOIN commodity c ON u.user_id = c.user_id where c.user_id = #{userId} and c.is_deleted = 0 and c.is_sold = 0")
    List<CommodityVO> getByUserId(Long userId);

    /**
     * 获取商品列表
     * @return
     */
    @Select("SELECT c.*, u.username, u.avatar  \n" +
            "        FROM users u  \n" +
            "        INNER JOIN commodity c ON u.user_id = c.user_id and c.is_deleted = 0 and c.is_sold = 0")
    List<CommodityVO> getList();

    @Select("SELECT c.*, u.username, u.avatar  \n" +
            "        FROM users u  \n" +
            "        INNER JOIN commodity c ON u.user_id = c.user_id and c.is_deleted = 0 and c.is_sold = 0 and commodity_id = #{id}")
    CommodityVO getById(Long id);

    /**
     * 根据商品id查询商品图片
     * @param id
     * @return
     */
    @Select("select image_url from commodity_images where commodity_id = #{id}")
    List<String> getImagesById(Long id);

    /**
     * 添加商品
     * @param commodity
     */
    void addCommodity(Commodity commodity);

    /**
     * 添加商品图片
     * @param images
     * @param id
     */
    void addCommodityImages(@Param("images")List<String> images, @Param("id")Long id);

    @Select("select * from commodity where commodity_id = #{id}")
    Commodity getCommodity(Long commodityId);
}
