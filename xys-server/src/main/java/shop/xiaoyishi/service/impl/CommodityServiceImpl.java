package shop.xiaoyishi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.xiaoyishi.entity.Commodity;
import shop.xiaoyishi.entity.User;
import shop.xiaoyishi.mapper.CommodityMapper;
import shop.xiaoyishi.mapper.UserMapper;
import shop.xiaoyishi.service.CommodityService;
import shop.xiaoyishi.vo.CommodityVO;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<CommodityVO> getByUserId(Long userId) {
        List<CommodityVO> commodityVOList = commodityMapper.getByUserId(userId);
        for (CommodityVO commodityVO : commodityVOList) {
            List<String> images = commodityMapper.getImagesById(commodityVO.getCommodityId());
            commodityVO.setImages(images);
        }
        return commodityVOList;
    }

    @Override
    public List<CommodityVO> getList() {
        List<CommodityVO> commodityVOList = commodityMapper.getList();
        for (CommodityVO commodityVO : commodityVOList) {
            List<String> images = commodityMapper.getImagesById(commodityVO.getCommodityId());
            commodityVO.setImages(images);
        }
        return commodityVOList;
    }
}
