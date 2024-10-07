package shop.xiaoyishi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import shop.xiaoyishi.vo.CommodityVO;
import shop.xiaoyishi.vo.PostVO;

import java.util.List;

@Mapper
public interface CollectMapper {
    @Select("select count(*) from favorites where user_id = #{userId}")
    Integer countCollect(Long userId);

    @Select("select commodity_id from favorites where user_id = #{userId}")
    List<Long> commodities(Long userId);

    @Select("select post_id from favorites where user_id = #{userId}")
    List<Long> posts(Long userId);
}
