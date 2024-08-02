package shop.xiaoyishi.service;

public interface FollowService {
    /**
     * 关注数
     * @param userId
     * @return
     */
    Integer countFollow(Long userId);

    /**
     * 粉丝数
     * @param userId
     * @return
     */
    Integer countBean(Long userId);
}
