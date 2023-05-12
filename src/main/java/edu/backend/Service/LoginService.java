package edu.backend.Service;

import edu.backend.Entity.User;
import edu.backend.Mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Service
public class LoginService {
    @Resource
    private UserMapper userMapper;
    public User login(String username, String password){
        User user = userMapper.findUserByUsername(username);
        if(user == null){
            return new User();
        } else if (Objects.equals(user.getPassword(), password)) {
            return user;
        }
        else
            return new User();

    }
    public User addNewUser(String username,String password,String mail,String birth){
        User userName = userMapper.findUserByUsername(username);
        if (userName!=null){
            return new User();
        }
        userMapper.addUser(username,password,mail,birth);
        User user= userMapper.findUserByUsername(username);
        return user;
    }
    public List<User> findAllUser(){
        return userMapper.findAllUser();
    }
    public boolean changePassword(String username, String mail,String newPassword){
        return userMapper.changePassword(username,mail,newPassword);
    }
    public int deleteUser(int id){
        return userMapper.deleteById(id);
    }
    public List<User> findUsersByName(String name){
        return userMapper.findUsersByUsername(name);
    }
    public boolean alterUser(int id,String name,String mail,String birth){
        return userMapper.updateUserById(id,name,mail,birth);
    }
    public User findUserById(int id){
        return userMapper.findUserById(id);
    }
}
