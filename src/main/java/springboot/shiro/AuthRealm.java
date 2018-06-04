package springboot.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import springboot.dao.UserMapper;
import springboot.domain.User;

/**
 * Created by qiangber on 18-4-12.
 */
public class AuthRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("doGetAuthorizationInfo +"  + principalCollection.toString());

        User user = (User) principalCollection.getPrimaryPrincipal();

        logger.info(user.getUsername() + ":" + user.getCnname());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        info.addRole("admin");

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("doGetAuthenticationInfo +"  + authenticationToken.toString());

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        logger.info(username + token.getPassword());

        User user = new User();
        user.setUsername(username);
        user = userMapper.selectOne(user);

        if (user == null) {
            throw new UnknownAccountException("账号不存在!");
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()), getName());
    }

}
