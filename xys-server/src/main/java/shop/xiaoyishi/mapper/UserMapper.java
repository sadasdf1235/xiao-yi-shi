package shop.xiaoyishi.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import shop.xiaoyishi.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 根据用户id查询用户
     * @param userId
     * @return
     */
    @Select("select user_id,username,phone,email,gender,address,current_location,create_time,update_time,avatar,create_user,update_user,status,online_status,password,is_deleted from users where user_id = #{userId} and is_deleted = 0")
    User getById(Long userId);

    /**
     * 根据用户号码查询用户
     * @param phone
     * @return
     */
    @Select("select user_id,username,phone,email,gender,address,current_location,create_time,update_time,avatar,create_user,update_user,status,online_status,password,is_deleted from users where phone = #{phone} and is_deleted = 0")
    User getByPhone(String phone);


    /**
     * 新增用户
     * @param User
     */
    @Insert("insert into users (username,email,address,current_location,password,phone,gender,create_time,update_time,create_user,update_user,status,online_status,avatar,is_deleted)" +
            " values" +
            " (#{username},#{email},#{address},#{currentLocation},#{password},#{phone},#{gender},#{createTime},#{updateTime},#{createUser},#{updateUser},#{status},#{onlineStatus},#{avatar},#{isDeleted})")
    void save(User User);

    /**
     * 用户信息更新
     * @param User
     */
    @Update("update users set username = #{username},email = #{email},address = #{address},current_location = #{currentLocation},phone = #{phone},gender = #{gender},update_time = #{updateTime},update_user = #{updateUser},status = #{status},online_status = #{onlineStatus},avatar = #{avatar} where user_id = #{userId} and is_deleted = 0")
    Integer update(User User);


    /**
     * 检查旧密码
     * @param userId
     * @param oldPassword
     * @return
     */
    @Select("select count(user_id) from users where user_id = #{userId} and password = #{oldPassword} and is_deleted = 0")
    Integer checkOldPassword(Long userId, String oldPassword);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    @Update("update users set password = #{newPassword} where user_id = #{userId} and is_deleted = 0")
    Integer updatePassword(Long userId, String newPassword);

    /**
     * 删除用户
     */
    @Update("update users set is_deleted = 1 where user_id = #{userId}")
    Integer delete(Long userId);

    /**
     * 统计用户数量
     */
    @Select("select count(user_id) from users where is_deleted = 0")
    Integer count();

    /**
     * 用户分页查询
     */
    @Select("select user_id,username,phone,email,gender,address,current_location,create_time,update_time,avatar,create_user,update_user,status,online_status,password,is_deleted from users where is_deleted = 0 limit #{offset},#{pageSize}")
    List<User> page(Integer offset, Integer pageSize);

    /**
     * 用户分页查询
     */
    @Select("select user_id,username,phone,email,gender,address,current_location,create_time,update_time,avatar,create_user,update_user,status,online_status,password,is_deleted from users where is_deleted = 0")
    List<User> pageHelp(Integer offset, Integer pageSize);
}
