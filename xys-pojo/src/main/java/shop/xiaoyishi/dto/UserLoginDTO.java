package shop.xiaoyishi.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * C端用户登录
 */
@Data
public class UserLoginDTO implements Serializable {
    // 验证码
    private String code;
    private String phone;
    // 密码
    private String password;

}
