package springdatarediscase;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.net.URL;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/8 17:26
 */
public class RedisUtilsTest extends BaseJUnit4Test {

    // inject the actual template
    @Autowired
    private RedisTemplate<String, String> template;

    @Test
    public void simpleTest(){

    }
}
