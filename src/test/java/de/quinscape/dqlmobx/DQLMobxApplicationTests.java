package de.quinscape.dqlmobx;

import de.quinscape.dqlmobx.runtime.DQLMobxApplication;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {
    DQLMobxApplication.class
})

//XXX: deactivated because it is slow and we have no context-requiring tests yet but keep this as example of how to do it.
@Ignore
public class DQLMobxApplicationTests
{

    @Test
    public void contextLoads()
    {
    }

}
