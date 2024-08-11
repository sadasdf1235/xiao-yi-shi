package shop.xiaoyishi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import shop.xiaoyishi.vo.PostVO;

import java.util.List;

@Mapper
public interface PostMapper {
    @Select("select count(*) from posts where user_id = #{userId}")
    Integer countPost(Long userId);

    @Select("select p.*,u.username,u.avatar from users u inner join posts p on u.user_id = p.user_id where p.is_deleted = 0")
    List<PostVO> postList();

    @Select("select p.*,u.username,u.avatar from users u inner join posts p on u.user_id = p.user_id where p.is_deleted = 0 and p.user_id = #{id}")
    List<PostVO> postListById(Long id);

    @Select("select p.*,u.username,u.avatar from users u inner join posts p on u.user_id = p.user_id where p.is_deleted = 0 and p.post_id = #{id}")
    PostVO postById(Long id);

    @Select("select image_url from post_images where post_id = #{id} and is_deleted = 0")
    List<String> getImagesById(Long id);

    @Select("select count(*) from likes where post_id = #{id} and is_deleted = 0")
    Long getLikesById(Long id);
}
