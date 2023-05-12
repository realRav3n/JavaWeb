package edu.backend.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.backend.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    void addUser(@Param("username")String username,@Param("password")String password,@Param("mail")String mail,@Param("birth") String birth);
    User findUserByUsername(@Param("username")String username);
    List<User> findAllUser();
    int deleteById(@Param("user_id") int user_id);
    boolean changePassword(@Param("username") String username, @Param("mail") String mail, @Param("password") String newPassword);
    List<User> findUsersByUsername(@Param("username")String username);
    boolean updateUserById(@Param("user_id") int user_id,@Param("username") String username, @Param("mail") String mail,@Param("birth") String birth);
    User findUserById(@Param("user_id") int user_id);
}
