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
    @Select("SELECT c.commodity_id,c.user_id,c.category_id,c.title,c.description,c.location,c.price,c.is_sold,c.create_time,c.update_time,c.is_deleted, u.username,u.avatar  \n" +
            "        FROM users u  \n" +
            "        INNER JOIN commodity c ON u.user_id = c.user_id where c.user_id = #{userId} and c.is_deleted = 0 and c.is_sold = 0 and is_deleted = 0")
    List<CommodityVO> getByUserId(Long userId);

    /**
     * 获取商品列表
     * @return
     */
    @Select("SELECT c.commodity_id,c.user_id,c.category_id,c.title,c.description,c.location,c.price,c.is_sold,c.create_time,c.update_time,c.is_deleted, u.username, u.avatar  \n" +
            "        FROM users u  \n" +
            "        INNER JOIN commodity c ON u.user_id = c.user_id and c.is_deleted = 0 and c.is_sold = 0")
    List<CommodityVO> getList();

    @Select("SELECT c.commodity_id,c.user_id,c.category_id,c.title,c.description,c.location,c.price,c.is_sold,c.create_time,c.update_time,c.is_deleted, u.username, u.avatar  \n" +
            "        FROM users u  \n" +
            "        INNER JOIN commodity c ON u.user_id = c.user_id and c.is_deleted = 0 and c.is_sold = 0 and commodity_id = #{id} and is_deleted = 0")
    CommodityVO getById(Long id);

    /**
     * 根据商品id查询商品图片
     * @param id
     * @return
     */
    @Select("select image_url from commodity_images where commodity_id = #{id} and is_deleted = 0")
    List<String> getImagesById(Long id);

    /**
     * 添加商品
     * @param commodity
     */
    Integer addCommodity(Commodity commodity);

    /**
     * 添加商品图片
     * @param images
     * @param id
     */
    Integer addCommodityImages(@Param("images")List<String> images, @Param("id")Long id);

    @Select("select commodity_id,user_id,category_id,title,description,location,price,is_sold,create_time,update_time,is_deleted from commodity where commodity_id = #{id} and is_deleted = 0")
    Commodity getCommodity(Long commodityId);
}
