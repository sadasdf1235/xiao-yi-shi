package shop.xiaoyishi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.xiaoyishi.mapper.CollectMapper;
import shop.xiaoyishi.service.CollectService;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    /**
     * 查询收藏数量
     */
    @Override
    public Integer countCollect(Long userId) {
        return collectMapper.countCollect(userId);
    }
}
