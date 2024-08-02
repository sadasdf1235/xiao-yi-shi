package shop.xiaoyishi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Integer userId;
    private String username;
    private String phone;
    private String email;
    private Integer gender; // 0: 男, 1: 女, 2: 其他
    private String address;
    private String password;
    private String currentLocation;
    private String avatar;
    private Integer status; // 0: 正常, 1: 封禁
    private Integer onlineStatus; // 0: 在线, 1: 不在线
    private Long createUser; // 创建人ID
    private Long updateUser; // 最后修改人ID
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
//    private Integer isDeleted; // 0: 未删, 1: 删除
}
