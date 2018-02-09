package springdatarediscase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/8 17:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class BaseJUnit4Test {

    @Test
    public void simpleTest(){

    }
}
