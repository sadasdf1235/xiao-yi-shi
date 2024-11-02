package shop.xiaoyishi.mapper;

import org.apache.ibatis.annotations.*;
import shop.xiaoyishi.entity.Collect;

import java.util.List;

@Mapper
public interface CollectMapper {
    /**
     * 收藏数量
     * @param userId
     * @return
     */
    @Select("select count(user_id) from favorites where user_id = #{userId} and is_deleted = 0")
    Integer countCollect(Long userId);

    /**
     * 商品收藏数量
     */
    @Select("select count(commodity_id) from favorites where user_id = #{userId} and is_deleted = 0")
    List<Long> collectCommodities(Long userId);

    /**
     * 帖子收藏数量
     */
    @Select("select count(post_id) from favorites where user_id = #{userId} and is_deleted = 0")
    List<Long> collectPosts(Long userId);


    /**
     * 收藏商品列表
     * @param userId
     * @return
     */
    @Select("select commodity_id from favorites where user_id = #{userId} and is_deleted = 0")
    List<Long> commodities(Long userId);

    /**
     * 收藏帖子列表
     * @param userId
     * @return
     */
    @Select("select post_id from favorites where user_id = #{userId} and is_deleted = 0")
    List<Long> posts(Long userId);

    /**
     * 新增收藏
     */
    @Insert("insert into favorites(user_id, commodity_id, post_id,create_time,update_time,is_deleted")
    void addCollect(Collect collect);

    /**
     * 删除收藏
     */
    @Update("update favorites set is_deleted = 1 where favorite_id = #{id}")
    void deleteCollect(Long id);
}
