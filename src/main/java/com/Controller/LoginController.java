package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String name,@RequestParam("password") String password
           , Model model,HttpSession session){
        if(StringUtils.hasText(name) && "123456".equals(password)){
            // 登录成功后，保存session
            session.setAttribute("loginUser",name);
           // return "dashboard";
            return "redirect:/dashboard.do"; // 使用重定向跳转到dashboard.html （假页面，防止跳转浏览器url携带参数，在MyMvcConfig配置）
        }else{
            System.out.println(1111);
            model.addAttribute("msg","用户名或密码错误");
            return "login"; // 跳转到login.html页面
        }
    }
}
