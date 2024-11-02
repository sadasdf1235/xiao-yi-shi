package shop.xiaoyishi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import shop.xiaoyishi.entity.Post;
import shop.xiaoyishi.vo.PostVO;

import java.util.List;

@Mapper
public interface PostMapper {
    @Select("select count(user_id) from posts where user_id = #{userId} and is_deleted = 0")
    Integer countPost(Long userId);

    @Select("select p.post_id,p.user_id,p.title,p.description,p.create_time,p.update_time,p.is_deleted,u.username,u.avatar from users u inner join posts p on u.user_id = p.user_id where p.is_deleted = 0 and is_deleted = 0")
    List<PostVO> postList();

    @Select("select p.post_id,p.user_id,p.title,p.description,p.create_time,p.update_time,p.is_deleted,u.username,u.avatar from users u inner join posts p on u.user_id = p.user_id where p.is_deleted = 0 and p.user_id = #{id} and is_deleted = 0")
    List<PostVO> postListById(Long id);

    @Select("select p.post_id,p.user_id,p.title,p.description,p.create_time,p.update_time,p.is_deleted,u.username,u.avatar from users u inner join posts p on u.user_id = p.user_id where p.is_deleted = 0 and p.post_id = #{id} and is_deleted = 0")
    PostVO postById(Long id);

    @Select("select image_url from post_images where post_id = #{id} and is_deleted = 0")
    List<String> getImagesById(Long id);

    @Select("select count(post_id) from likes where post_id = #{id} and is_deleted = 0")
    Long getLikesById(Long id);

    @Select("select post_id,user_id,title,description,create_time,update_time,is_deleted from posts where post_id = #{postId} and is_deleted = 0")
    Post getPost(Long postId);
}
