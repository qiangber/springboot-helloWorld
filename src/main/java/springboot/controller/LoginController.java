package springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.util.Strings;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.utils.Result;

/**
 * Created by qiangber on 18-4-11.
 */
@Api("登录模块")
@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "rememberMe", value = "记住我", paramType = "query", dataType = "Boolean")
    })
    @PostMapping("/login")
    public String login(String username, String password, @RequestParam(defaultValue = "false") boolean rememberMe,
                        Model model) {
        logger.info(username + password + rememberMe);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(rememberMe);

        String errorMsg = "";
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            errorMsg = "账号不存在";
        } catch (IncorrectCredentialsException e) {
            errorMsg = "账号或密码不正确!";
        } catch (LockedAccountException e) {
            errorMsg = "账号已锁定,请联系管理员!";
        } catch (AuthenticationException e) {
            logger.error("Authentication error", e);
            errorMsg = "账户验证失败!";
        }

        model.addAttribute("msg", errorMsg);

        if (Strings.isEmpty(errorMsg)) {
            return "redirect:hello";
        } else {
            return "login.html";
        }
    }

    @PostMapping("/login2")
    @ResponseBody
    public Result login2(String username, String password, boolean rememberMe) {
        logger.info(username + password + rememberMe);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(rememberMe);

        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return Result.error("账号不存在");
        } catch (IncorrectCredentialsException e) {
            return Result.error("账号或密码不正确!");
        } catch (LockedAccountException e) {
            return Result.error("账号已锁定,请联系管理员!");
        } catch (AuthenticationException e) {
            logger.error("Authentication error", e);
            return Result.error("账户验证失败!");
        }

        return Result.ok();
    }

    @PostMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:login.html";
    }

}
