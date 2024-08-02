package shop.xiaoyishi.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import shop.xiaoyishi.constant.MessageConstant;
import shop.xiaoyishi.constant.PasswordConstant;
import shop.xiaoyishi.constant.StatusConstant;
import shop.xiaoyishi.context.BaseContext;
import shop.xiaoyishi.dto.UserLoginDTO;
import shop.xiaoyishi.dto.UserRegisterDTO;
import shop.xiaoyishi.entity.User;
import shop.xiaoyishi.exception.AccountLockedException;
import shop.xiaoyishi.exception.AccountNotFoundException;
import shop.xiaoyishi.exception.PasswordErrorException;
import shop.xiaoyishi.mapper.UserMapper;
import shop.xiaoyishi.service.UserService;

import java.time.LocalDateTime;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    
    /**
     * 登录
     * @param userLoginDTO
     * @return
     */
    @Override
    public User login(UserLoginDTO userLoginDTO) {
        String phone = userLoginDTO.getPhone();
        String password = userLoginDTO.getPassword();
        // 验证码
        String code = userLoginDTO.getCode();

        password = DigestUtils.md5DigestAsHex(password.getBytes());
        log.info("转换后的密码为:{}",password);
        //1、根据手机号查询数据库中的数据
        User user = userMapper.getByPhone(phone);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (user == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对
        if ("".equals(code) && !password.equals(user.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (user.getStatus() == StatusConstant.DISABLE) {
            //账号被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //3、返回实体对象
        return user;
    }

    /**
     * 用户注册
     * @param userRegisterDTO
     * @return
     */
    @Override
    public User register(UserRegisterDTO userRegisterDTO) {
        if(userMapper.getByPhone(userRegisterDTO.getPhone()) != null){
            throw new AccountNotFoundException(MessageConstant.ALREADY_EXISTS);
        }
        User user = new User();
        BeanUtils.copyProperties(userRegisterDTO,user);

        // 密码
        user.setPassword(DigestUtils.md5DigestAsHex(userRegisterDTO.getPhone().getBytes()));
        // 状态
        user.setStatus(StatusConstant.ENABLE);
        // 时间
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        // 创建人
        user.setCreateUser(BaseContext.getCurrentId());
        user.setUpdateUser(BaseContext.getCurrentId());

        user.setOnlineStatus(StatusConstant.DISABLE);

        // 销毁线程池中的变量
        BaseContext.removeCurrentId();

        userMapper.save(user);
        return null;
    }

    /***
     * 查询用户信息
     * @param userId
     * @return
     */
    @Override
    public User userInfo(Long userId) {
        return userMapper.getById(userId);
    }
}
