package edu.backend.Controller;


import edu.backend.Entity.User;
import edu.backend.Service.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession; //千万别用javax！
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController extends SessionController{

    @Autowired
    private LoginService userLogin;
    @RequestMapping("login")
    public String login(String username, String password, HttpServletRequest request, HttpServletResponse rsp) {
        User data = userLogin.login(username, password);
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        String sessionId = request.getSession().getId();

        System.out.println(session.getId());
        //向session对象中完成数据的绑定(这个session是全局的,项目的任何位置都可以访问)
        session.setAttribute("uid",data.getUser_id());
        session.setAttribute("username",data.getUserName());
        System.out.println(session.getAttribute("uid").toString());
        if (cookies == null) {
            Cookie cookie = new Cookie("JSESSIONID", sessionId);
            cookie.setMaxAge(5 * 60);
            cookie.setPath("/hand");
            rsp.addCookie(cookie);
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    cookie.setMaxAge(5 * 60);
                    cookie.setValue(sessionId);
                    cookie.setDomain("localhost");
                    cookie.setPath("/hand");
                    rsp.addCookie(cookie);
                    break;
                }
            }
        }

        return data.getUser_id().toString();
    }

    @PostMapping("addUser")
    public String addNewUser(@RequestParam String username, @RequestParam String password, @RequestParam String mail, @RequestParam String birth){
        log.info(username+"尝试注册");
        return userLogin.addNewUser(username,password,mail,birth).getUser_id().toString();
    }
    @GetMapping("findAllUser")
    public List<User> findAllUser(){
        log.info("查看所有用户");
        return userLogin.findAllUser();
    }
    @PostMapping("changePassword")
    public boolean changePassword(@RequestParam String username, @RequestParam String mail,@RequestParam String newPassword){
        log.info(username+"尝试修改密码");
        return userLogin.changePassword(username,mail,newPassword);
    }
    @PostMapping("deleteUser")
    public int deleteUser(@RequestParam String user_id){
        log.info("删除"+user_id);
        return userLogin.deleteUser(Integer.parseInt(user_id));
    }
    @GetMapping("findUserByName")
    public List<User> findUserByName(@RequestParam String username){
        log.info("查询"+username);
        return userLogin.findUsersByName(username);
    }
    @PostMapping("alterUser")
    public boolean alterUser(@RequestParam String user_id,@RequestParam String username,@RequestParam String mail, @RequestParam String birth){
        log.info("修改"+username);
        return userLogin.alterUser(Integer.parseInt(user_id), username, mail, birth);
    }
    @GetMapping("findUserById")
    public User findUserById(@RequestParam String user_id){
        return userLogin.findUserById(Integer.parseInt(user_id));
    }
    @GetMapping("currentUser")
    public String minePage(HttpServletRequest request,HttpServletResponse response){
        System.out.println(request.getHeader("User-Agent"));
        System.out.println(request.getSession().getId());
        log.info("当前用户信息");
        String result="";
        try {

            result=request.getSession().getAttribute("uid").toString();
        }
        catch (Exception e){
            log.info(String.valueOf(e));
        }
        return result;
    }

}
