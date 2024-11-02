package shop.xiaoyishi.mapper;

import org.apache.ibatis.annotations.*;
import shop.xiaoyishi.entity.History;
import shop.xiaoyishi.vo.HistoryVO;

import java.util.List;

@Mapper
public interface HistoryMapper {
    /**
     * 历史数量
     * @param userId
     * @return
     */
    @Select("select count(user_id) from history where user_id = #{userId} and is_deleted = 0")
    Integer countHistory(Long userId);

    /**
     * 帖子历史列表
     * @param userId
     * @return
     */
    @Select("select history_id,userId, commodityId, postId,create_time,update_time,is_deleted from history where user_id = #{userId} and postId != null and is_deleted = 0")
    List<HistoryVO> historyPostList(Long userId);

    /**
     * 商品历史列表
     * @param userId
     */
    @Select("select userId, commodityId, postId,create_time,update_time,is_deleted from history where user_id = #{userId} and commodityId != null and is_deleted = 0")
    List<HistoryVO> historyCommodityList(Long userId);

    /**
     * 查询所有历史
     * @param userId
     */
    @Select("select userId, commodityId, postId,create_time,update_time,is_deleted from history where user_id = #{userId} and is_deleted = 0")
    List<HistoryVO> historyList(Long userId);

    /**
     * 删除历史
     */
    @Update("update history set is_deleted = 1 where id = #{id}")
    void deleteHistory(Long id);

    /**
     * 删除所有历史
     */
    @Update("update history set is_deleted = 1 where user_id = #{userId}")
    void deleteAllHistory(Long userId);

    /**
     * 删除帖子历史
     */
    @Update("update history set is_deleted = 1 where user_id = #{userId} and postId = #{postId}")
    void deletePostHistory(Long userId, Long postId);

    /**
     * 删除商品历史
     */
    @Update("update history set is_deleted = 1 where user_id = #{userId} and commodityId = #{commodityId}")
    void deleteCommodityHistory(Long userId, Long commodityId);

    /**
     * 添加历史
     */
    @Insert("insert into history(userId, commodityId, postId,create_time,update_time,is_deleted) " +
            "values(#{userId}, #{commodityId}, #{postId}), #{createTime},#{updateTime},#{isDeleted}")
    void addHistory(History history);
}
