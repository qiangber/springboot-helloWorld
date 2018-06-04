package springboot;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by qiangber on 18-4-11.
 */
@Component
public class SimpleService {

    private static Logger logger = LoggerFactory.getLogger(SimpleService.class);

    @RequiresPermissions("write")
    public void writeRestrictedCall() {
        logger.info("Executing method that requires the 'write' permission.");
    }

    @RequiresPermissions("read")
    public void readRestrictedCall() {
        logger.info("Executing method that requires the 'read' permission.");
    }

}
