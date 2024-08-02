package shop.xiaoyishi.service;

import shop.xiaoyishi.dto.UserLoginDTO;
import shop.xiaoyishi.dto.UserRegisterDTO;
import shop.xiaoyishi.entity.User;

public interface UserService {
    /**
     * 登录
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);
    /**
     * 注册
     * @param userRegisterDTO
     * @return
     */
    User register(UserRegisterDTO userRegisterDTO);

    /**
     * 查询用户信息
     * @param userId
     */
    User userInfo(Long userId);
}
