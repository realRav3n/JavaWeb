package edu.backend.Controller;


import jakarta.servlet.http.HttpSession;

public class SessionController {
    /**
     * 获取session对象中的uid
     * @param session session对象
     * @return  当前登录的用户uid的值
     */
    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("user_id")
                .toString());
    }

    /**
     * 获取当前登录用户的username
     * @param session session对象
     * @return  当前登录用户的用户名称
     * 在实现类中重写父类中的toString（），不是句柄信息的输出
     */
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
