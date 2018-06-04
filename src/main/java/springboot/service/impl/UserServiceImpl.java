package springboot.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import springboot.dao.UserMapper;
import springboot.domain.User;
import springboot.service.UserService;
import springboot.shiro.ShiroUtils;

/**
 * Created by qiangber on 18-4-16.
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    public boolean save(User user) {
        String salt = RandomStringUtils.randomAlphabetic(20);
        user.setSalt(salt);
        user.setPassword(ShiroUtils.sha256(user.getPassword(), salt));

        return this.insert(user);
    }

}
