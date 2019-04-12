package com.fenger.sys.controller;

import com.fenger.sys.domain.User;
import com.fenger.sys.utils.ActivityUser;
import com.fenger.sys.utils.WebUtils;
import com.fenger.sys.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private final static String URL_LOGIN = "login/";
    @RequestMapping(URL_LOGIN+"login")
    public String login(UserVo userVo) {
        //组装用户名 密码
        UsernamePasswordToken token = new UsernamePasswordToken(userVo.getLoginname(), userVo.getPwd());
        Subject subject = SecurityUtils.getSubject();
        HttpSession session = WebUtils.getCurrentSession();
        try {
            //认证
            subject.login(token);
            System.out.println("是否认证成功"+subject.isAuthenticated());
            ActivityUser user = (ActivityUser) subject.getPrincipal();
            session.setAttribute("user",user.getUser());
            return "sys/index";
        } catch (UnknownAccountException e) {
            System.out.println("用户名不存在");
            session.setAttribute("msg","用户名不存在");
        }catch (IncorrectCredentialsException e) {
            System.out.println("密码不正确");
            session.setAttribute("msg","密码不正确");
        }catch (Exception e){
            System.out.println(e.getMessage());
            session.setAttribute("msg","登录失败");
        }
        return "sys/login";
    }
}
