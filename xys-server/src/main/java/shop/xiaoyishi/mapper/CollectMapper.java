package shop.xiaoyishi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface CollectMapper {
    @Select("select count(*) from favorites where user_id = #{userId}")
    Integer countCollect(Long userId);
}
