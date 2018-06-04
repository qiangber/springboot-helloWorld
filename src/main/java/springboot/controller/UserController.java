package springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.dao.UserMapper;
import springboot.domain.User;
import springboot.service.UserService;
import springboot.shiro.ShiroUtils;

/**
 * Created by qiangber on 18-4-13.
 */
@Api("用户模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户信息", notes = "save", response = Boolean.class)
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User")
    @PostMapping
    public Boolean insert(@RequestBody User user) {

        return userService.insert(user);
    }

}
