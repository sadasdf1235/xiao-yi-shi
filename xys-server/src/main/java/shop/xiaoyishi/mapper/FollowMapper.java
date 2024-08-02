package shop.xiaoyishi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FollowMapper {
    // 粉丝数
    @Select("select count(*) from follows where following_id = ${userId}")
    Integer countFollow(Long userId);

    // 关注数
    @Select("select count(*) from follows where follower_id = ${userId}")
    Integer countBean(Long userId);
}
