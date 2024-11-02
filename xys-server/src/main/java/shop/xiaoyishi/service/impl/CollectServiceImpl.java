package shop.xiaoyishi.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.xiaoyishi.entity.Commodity;
import shop.xiaoyishi.entity.Post;
import shop.xiaoyishi.entity.User;
import shop.xiaoyishi.mapper.CollectMapper;
import shop.xiaoyishi.mapper.CommodityMapper;
import shop.xiaoyishi.mapper.PostMapper;
import shop.xiaoyishi.mapper.UserMapper;
import shop.xiaoyishi.service.CollectService;
import shop.xiaoyishi.vo.CollectVO;
import shop.xiaoyishi.vo.CommodityVO;
import shop.xiaoyishi.vo.PostVO;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询收藏数量
     */
    @Override
    public Integer countCollect(Long userId) {
        return collectMapper.countCollect(userId);
    }

    /**
     * 查询收藏商品
     *
     * @param userId
     * @return
     */
    @Override
    public List<CommodityVO> commodities(Long userId) {
        List<CommodityVO> commodityVOList = new ArrayList<>();
        List<Long> commodityIds = collectMapper.commodities(userId);
        if (commodityIds.isEmpty()) return null;
        for (Long commodityId : commodityIds) {
            if (commodityId == null) continue;
            CommodityVO commodityVO = new CommodityVO();
            Commodity commodity = commodityMapper.getCommodity(commodityId);
            List<String> images = commodityMapper.getImagesById(commodityId);
            commodityVO.setImages(images);
            BeanUtils.copyProperties(commodity, commodityVO);
            commodityVOList.add(commodityVO);
        }
        return commodityVOList;
    }

    /**
     * 查询收藏帖子
     *
     * @param userId
     * @return
     */
    @Override
    public List<PostVO> posts(Long userId) {
        List<PostVO> postVOList = new ArrayList<>();
        List<Long> postIds = collectMapper.posts(userId);
        if (postIds.isEmpty()) return null;
        for (Long postId : postIds) {
            if (postId == null) continue;
            PostVO postVO = new PostVO();
            Post post = postMapper.getPost(postId);
            postVO.setImages(postMapper.getImagesById(postId));
            BeanUtils.copyProperties(post, postVO);
            postVOList.add(postVO);
        }
        return postVOList;
    }

    @Override
    public List<CollectVO> collectList(Long userId, Integer type) {
        List<CollectVO> result = new ArrayList<>();
        List<Long> commodityIds = collectMapper.commodities(userId);
        List<Long> postIds = collectMapper.posts(userId);

        // 处理商品
        if (type != 2) { // 如果type不是2，则处理商品
            for (Long commodityId : commodityIds) {
                if (commodityId == null) {
                    continue; // 跳过null的commodityId
                }
                CollectVO collectVO = new CollectVO();
                Commodity commodity = commodityMapper.getCommodity(commodityId);
                if (commodity == null) {
                    continue; // 跳过不存在的商品（可选，取决于您是否希望处理null的商品）
                }
                List<String> images = commodityMapper.getImagesById(commodityId);
                User user = userMapper.getById(commodity.getUserId());
                BeanUtils.copyProperties(commodity, collectVO);
                collectVO.setImages(images);
                collectVO.setId(commodityId);
                collectVO.setType(1);
                collectVO.setAvatar(user.getAvatar());
                collectVO.setUsername(user.getUsername());
                collectVO.setUserId(userId);
                result.add(collectVO);
            }
        }

        // 处理帖子
        if (type != 1) { // 如果type不是1，则处理帖子
            for (Long postId : postIds) {
                if (postId == null) {
                    continue; // 跳过null的postId
                }
                CollectVO collectVO = new CollectVO();
                Post post = postMapper.getPost(postId);
                if (post == null) {
                    continue; // 跳过不存在的帖子（可选，取决于您是否希望处理null的帖子）
                }
                List<String> images = postMapper.getImagesById(postId);
                User user = userMapper.getById(post.getUserId());
                BeanUtils.copyProperties(post, collectVO);
                collectVO.setImages(images);
                collectVO.setId(postId);
                collectVO.setType(2);
                collectVO.setAvatar(user.getAvatar());
                collectVO.setUsername(user.getUsername());
                collectVO.setUserId(userId);
                result.add(collectVO);
            }
        }

        return result; // 返回可能包含部分结果的列表
    }
}
