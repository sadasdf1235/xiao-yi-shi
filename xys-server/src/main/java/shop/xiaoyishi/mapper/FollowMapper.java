package shop.xiaoyishi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FollowMapper {
    // 粉丝数
    @Select("select count(following_id) from follows where following_id = ${userId} and is_deleted = 0")
    Integer countFollow(Long userId);

    // 关注数
    @Select("select count(follower_id) from follows where follower_id = ${userId} and is_deleted = 0")
    Integer countBean(Long userId);
}
