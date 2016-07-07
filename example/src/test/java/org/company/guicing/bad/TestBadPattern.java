package org.company.guicing.bad;

import com.google.inject.Binder;
import com.google.inject.Module;
import org.company.guicing.MockSocketLibrary;
import org.company.guicing.lib.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBadPattern {

    private MockSocketLibrary mockSocket = new MockSocketLibrary();
    private Router router;

    @Before
    public void setup() {
        router = new Router(new SocketLibrary(), new RouteInvoker(new SomeUtil()));
    }

    @Test
    public void testBasic() {

        int id = 44;
        RouteResponse response = router.fetchResp(id);

        Assert.assertEquals(id+20, response.getScore());

    }

    private class TestModule implements Module {

        @Override
        public void configure(Binder binder) {
            binder.bind(SocketLibrary.class).toInstance(mockSocket);
        }
    }

}
