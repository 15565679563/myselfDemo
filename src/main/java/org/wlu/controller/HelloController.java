package org.wlu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wlu.entity.*;

import java.util.Arrays;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/view")
    public String hello(Model model) {
        // 构造用户数据
        User user = new User("张三", 25, Arrays.asList("读书", "编程", "旅行"));

        // 将数据存入 Model（键名 user 对应模板中的 ${user}）
        model.addAttribute("user", user);

        // 返回模板名称（无需后缀，对应 templates/hello.ftl）
        return "hello";
    }
}