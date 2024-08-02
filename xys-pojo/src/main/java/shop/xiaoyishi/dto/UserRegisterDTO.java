package shop.xiaoyishi.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户端用户注册，密码注册
 */
@Data
public class UserRegisterDTO implements Serializable {
    private String phone;
    // 密码
    private String password;
    private Integer gender;
    private String username;
}
