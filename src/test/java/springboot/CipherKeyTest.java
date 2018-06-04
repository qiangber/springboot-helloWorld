package springboot;

import org.apache.shiro.codec.Base64;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

/**
 * Created by qiangber on 18-4-16.
 */
public class CipherKeyTest {

    @Test
    public void generate() {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecretKey secretKey = keyGenerator.generateKey();
        System.out.println(Base64.encodeToString(secretKey.getEncoded()));
    }

}
