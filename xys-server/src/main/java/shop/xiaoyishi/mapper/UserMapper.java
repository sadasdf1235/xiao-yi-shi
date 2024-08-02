package shop.xiaoyishi.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import shop.xiaoyishi.entity.User;

@Mapper
public interface UserMapper {
    /**
     * 根据用户id查询用户
     * @param userId
     * @return
     */
    @Select("select * from users where user_id = #{userId}")
    User getById(Long userId);

    /**
     * 根据用户号码查询用户
     * @param phone
     * @return
     */
    @Select("select * from users where phone = #{phone}")
    User getByPhone(String phone);


    /**
     * 新增用户
     * @param User
     */
    @Insert("insert into users (username,password,phone,gender,create_time,update_time,create_user,update_user,status,online_status)" +
            " values" +
            " (#{username},#{password},#{phone},#{gender},#{createTime},#{updateTime},#{createUser},#{updateUser},#{status},#{onlineStatus})")
    void save(User User);

    /**
     * 用户分页查询
     * @param UserPageQueryDTO
     * @return
     */
//    Page<User> pageQuery(UserPageQueryDTO UserPageQueryDTO);

    /**
     * 用户信息更新
     * @param User
     */
    void update(User User);


    @Select("select count(name) from users where user_id = #{userId} and password = #{oldPassword}")
    int checkOldPas(Long userId, String oldPassword);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    @Update("update users set password = #{newPassword} where user_id = #{userId}")
    void editPas(Long userId, String newPassword);
}
