package shop.xiaoyishi.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private Integer follows;
    private Integer beans;
    private Integer collects;
    private Integer histories;
    private Integer posts;
    private Integer userId;
    private String username;
    private String phone;
    private String email;
    private Integer gender; // 0: 男, 1: 女, 2: 其他
    private String address;
    private String currentLocation;
    private String avatar;
    private Integer status; // 0: 正常, 1: 封禁
    private Integer onlineStatus; // 0: 在线, 1: 不在线
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
