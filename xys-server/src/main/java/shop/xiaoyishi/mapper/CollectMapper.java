package shop.xiaoyishi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectMapper {
    @Select("select count(*) from favorites where user_id = #{userId}")
    Integer countCollect(Long userId);

    @Select("select commodity_id from favorites where user_id = #{id} and is_deleted = 0")
    List<Long> collectCommodity(Long id);

    @Select("select post_id from favorites where user_id = #{id} and is_deleted = 0")
    List<Long> collectPost(Long id);
}
