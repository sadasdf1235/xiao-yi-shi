package shop.xiaoyishi.service;

import shop.xiaoyishi.entity.Post;
import shop.xiaoyishi.vo.PostVO;

import java.util.List;

public interface PostService {
    /**
     * 查询帖子数量
     */
    Integer countPost(Long userId);

    /**
     * 帖子列表
     * @return
     */
    List<PostVO> postList();

    Post getPost(Long postId);

    /**
     * 用户帖子列表
     * @return
     */
    List<PostVO> postListById(Long id);
}
