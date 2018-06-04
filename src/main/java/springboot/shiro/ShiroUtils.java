package springboot.shiro;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by qiangber on 18-4-13.
 */
public class ShiroUtils {

    public final static String HASH_ALGORITHM_NAME = Sha256Hash.ALGORITHM_NAME;

    public final static int HASH_ITERATIONS = 16;

    public static String sha256(String password, String salt) {
        return new SimpleHash(HASH_ALGORITHM_NAME, password, salt, HASH_ITERATIONS).toString();
    }

}
