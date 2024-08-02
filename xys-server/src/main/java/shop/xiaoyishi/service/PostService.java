package shop.xiaoyishi.service;

import shop.xiaoyishi.vo.PostVO;

import java.util.List;

public interface PostService {
    /**
     * 查询帖子数量
     */
    Integer countPost(Long userId);

    List<PostVO> postList();
}
