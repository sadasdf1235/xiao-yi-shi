package shop.xiaoyishi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.xiaoyishi.mapper.FollowMapper;
import shop.xiaoyishi.service.FollowService;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    private FollowMapper followMapper;
    /**
     * 关注数
     * @param userId
     * @return
     */
    @Override
    public Integer countFollow(Long userId) {
        return followMapper.countFollow(userId);
    }

    /**
     * 粉丝数
     * @param userId
     * @return
     */
    @Override
    public Integer countBean(Long userId) {
        return followMapper.countBean(userId);
    }
}
