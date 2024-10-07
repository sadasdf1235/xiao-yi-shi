package shop.xiaoyishi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.xiaoyishi.entity.Post;
import shop.xiaoyishi.mapper.FollowMapper;
import shop.xiaoyishi.mapper.PostMapper;
import shop.xiaoyishi.service.PostService;
import shop.xiaoyishi.vo.PostVO;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private FollowMapper followMapper;
    @Override
    /**
     * 用户帖子数量
     * @return
     */
    public Integer countPost(Long userId) {
        return postMapper.countPost(userId);
    }

    @Override
    /**
     * 帖子列表
     * @return
     */
    public List<PostVO> postList() {
        List<PostVO> postVOS = postMapper.postList();
        return getPostVOS(postVOS);
    }

    /**
     * 用户帖子列表
     * @return
     */
    @Override
    public List<PostVO> postListById(Long id) {
        List<PostVO> postVOS = postMapper.postListById(id);
        return getPostVOS(postVOS);
    }

    private List<PostVO> getPostVOS(List<PostVO> postVOS) {
        for (PostVO postVO : postVOS) {
            Integer countBean = followMapper.countBean(postVO.getUserId());
            Long postId = postVO.getPostId();
            postVO.setImages(postMapper.getImagesById(postId));
            postVO.setLikes(postMapper.getLikesById(postId));
            postVO.setFans(Long.valueOf(countBean));
        }
        return postVOS;
    }

    @Override
    public Post getPost(Long postId) {
        return postMapper.getPost(postId);
    }
}
