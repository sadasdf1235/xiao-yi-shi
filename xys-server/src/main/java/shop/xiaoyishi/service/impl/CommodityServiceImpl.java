package shop.xiaoyishi.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.xiaoyishi.dto.CommodityDTO;
import shop.xiaoyishi.entity.Commodity;
import shop.xiaoyishi.entity.User;
import shop.xiaoyishi.mapper.CommodityMapper;
import shop.xiaoyishi.mapper.UserMapper;
import shop.xiaoyishi.service.CommodityService;
import shop.xiaoyishi.vo.CommodityVO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
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

    @Override
    @Transactional
    public void addCommodity(CommodityDTO commodityDTO) {
        Commodity commodity = new Commodity();
        BeanUtils.copyProperties(commodityDTO,commodity);
        commodity.setUpdateTime(LocalDateTime.now());
        commodity.setIsDeleted(0);
        commodityMapper.addCommodity(commodity);
        log.info("id----{}",commodity.getCommodityId());
        commodityMapper.addCommodityImages(commodityDTO.getImages(),commodity.getCommodityId());
    }
}
