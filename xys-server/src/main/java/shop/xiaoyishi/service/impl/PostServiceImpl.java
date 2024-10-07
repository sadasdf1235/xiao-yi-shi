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
    public Integer countPost(Long userId) {
        return postMapper.countPost(userId);
    }

    @Override
    public List<PostVO> postList() {
        List<PostVO> postVOS = postMapper.postList();
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
