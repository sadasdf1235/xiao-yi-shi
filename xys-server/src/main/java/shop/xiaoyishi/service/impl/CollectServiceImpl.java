package shop.xiaoyishi.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.xiaoyishi.entity.Post;
import shop.xiaoyishi.mapper.CollectMapper;
import shop.xiaoyishi.mapper.CommodityMapper;
import shop.xiaoyishi.mapper.PostMapper;
import shop.xiaoyishi.service.CollectService;
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
    /**
     * 查询收藏数量
     */
    @Override
    public Integer countCollect(Long userId) {
        return collectMapper.countCollect(userId);
    }

    @Override
    /**
     * 查询收藏的商品
     * @param id
     * @return
     */
    public List<CommodityVO> collectCommodity(Long id) {
        List<Long> longs = collectMapper.collectCommodity(id);
        if(longs.isEmpty()){
            return null;
        }
        ArrayList<CommodityVO> commodityVOS = new ArrayList<>();
        for (Long cId :longs){
            CommodityVO commodityVO = commodityMapper.getById(cId);
            List<String> images = commodityMapper.getImagesById(cId);
            commodityVO.setImages(images);
            commodityVOS.add(commodityVO);
        }
        return commodityVOS;
    }

    @Override
    /**
     * 查询收藏的帖子
     * @param id
     * @return
     */
    public List<PostVO> collectPost(Long id) {
        List<Long> longs = collectMapper.collectPost(id);
        if(longs.isEmpty()){
            return null;
        }
        ArrayList<PostVO> postVOS = new ArrayList<>();
        for (Long pId : longs) {
            PostVO postVO = postMapper.postById(pId);
            List<String> images = postMapper.getImagesById(pId);
            postVO.setImages(images);
            postVOS.add(postVO);
        }
        return postVOS;
    }
}
