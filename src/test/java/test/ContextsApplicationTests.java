package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ContextsApplication.class)
public class ContextsApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private String foo;

    @Test
    public void shouldBeFoo() {
        assertEquals("foo", foo);
    }

}
