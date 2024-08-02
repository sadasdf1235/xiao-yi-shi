package shop.xiaoyishi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HistoryMapper {
    @Select("select count(*) from history where user_id = #{userId}")
    Integer countHistory(Long userId);
}
