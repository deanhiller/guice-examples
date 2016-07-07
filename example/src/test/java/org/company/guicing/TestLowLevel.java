package org.company.guicing;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import org.company.guicing.lib.RouteInvoker;
import org.company.guicing.lib.RouteResponse;
import org.company.guicing.lib.SocketLibrary;
import org.company.guicing.lib.SomeUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLowLevel {

    private MockSomeUtil mockSomeUtil = new MockSomeUtil();
    private RouteInvoker app;

    @Before
    public void setup() {
        Module moduleWithTestOverrides = Modules.override(BasicGuiceMain.getProductionModules()).with(new TestModule());
        Injector injector = Guice.createInjector(moduleWithTestOverrides);
        app = injector.getInstance(RouteInvoker.class);
    }

    @Test
    public void testSmallUnit() {
        int score = 55;
        mockSomeUtil.setCachedResponse(new RouteResponse(score));
        RouteResponse response = app.sendRequestIntoSystem(999);

        Assert.assertEquals(score, response.getScore());
    }

    private class TestModule implements Module {

        @Override
        public void configure(Binder binder) {
            binder.bind(SomeUtil.class).toInstance(mockSomeUtil);
        }
    }

}
