import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.MessageService;
import service.MockMessageService;

import static org.junit.Assert.assertEquals;

public class MyApplicationTest {
    private Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(MessageService.class).to(MockMessageService.class);
            }
        });
    }

    @After
    public void tearDown() throws Exception {
        injector = null;
    }

    @Test
    public void sendMessage() throws Exception {
        MyApplication appTest = injector.getInstance(MyApplication.class);
        assertEquals(true, appTest.sendMessage("Hi Pankaj", "pankaj@abc.com"));
    }

}