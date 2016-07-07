package org.company.guicing;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import org.company.guicing.lib.RouteResponse;
import org.company.guicing.lib.SocketLibrary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestHighLevel {

    private MockSocketLibrary mockSocket = new MockSocketLibrary();
    private App app;

    @Before
    public void setup() {
        Module moduleWithTestOverrides = Modules.override(BasicGuiceMain.getProductionModules()).with(new TestModule());
        Injector injector = Guice.createInjector(moduleWithTestOverrides);
        app = injector.getInstance(App.class);
        app.start();
    }

    @Test
    public void testBasic() {

        int id = 44;
        RouteResponse response = app.sendRequestIn(44);

        Assert.assertEquals(id+20, response.getScore());

    }

    private class TestModule implements Module {

        @Override
        public void configure(Binder binder) {
            binder.bind(SocketLibrary.class).toInstance(mockSocket);
        }
    }
}
