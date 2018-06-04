package springboot;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by qiangber on 18-4-11.
 */
@Component
public class QuickStart {

    private static Logger logger = LoggerFactory.getLogger(SimpleService.class);

    @Autowired
    private SecurityManager securityManager;

    @Autowired
    private SimpleService simpleService;

    public void run() {
        Subject subject = SecurityUtils.getSubject();

        Assert.isTrue(!subject.isAuthenticated());

        UsernamePasswordToken token = new UsernamePasswordToken("joe.coder", "password");
        subject.login(token);

        subject.checkRole("user");

        Assert.isTrue(!subject.hasRole("admin"));

        subject.checkPermission("read");

        simpleService.readRestrictedCall();

        try {
            simpleService.writeRestrictedCall();
        } catch (AuthorizationException e) {
            logger.info("Subject was NOT allowed to execute method 'writeRestrictedCall'");
        }

        subject.logout();
        Assert.isTrue(!subject.isAuthenticated());

    }

    @PostConstruct
    private void initStaticSecurityManager() {
        SecurityUtils.setSecurityManager(securityManager);
    }
}
