package springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qiangber on 18-4-16.
 */
@Controller
public class PageController {

    @RequestMapping(value = {"index.html"})
    public String index(){
        return "index";
    }

    @RequestMapping("login.html")
    public String login(){
        return "login";
    }

    @RequestMapping("403.html")
    public String notAuthorize() {
        return "403.html";
    }

    @RequestMapping("404.html")
    public String notFound(){
        return "404";
    }

}
