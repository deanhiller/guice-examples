package org.company.guicing;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import org.company.guicing.lib.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLowLevel {

    private MockRouteInvoker mockInvoker = new MockRouteInvoker();
    private Router app;

    @Before
    public void setup() {
        Module moduleWithTestOverrides = Modules.override(BasicGuiceMain.getProductionModules()).with(new TestModule());
        Injector injector = Guice.createInjector(moduleWithTestOverrides);
        app = injector.getInstance(Router.class);
    }

    @Test
    public void testSmallUnit() {
        int score = 55;
        mockInvoker.setCachedResponse(new RouteResponse(score));

        RouteResponse response = app.fetchResp(999);

        int cachedRequest = mockInvoker.getCachedRequest();
        Assert.assertEquals(999, cachedRequest);
        Assert.assertEquals(score, response.getScore());
    }

    private class TestModule implements Module {

        @Override
        public void configure(Binder binder) {
            binder.bind(RouteInvoker.class).toInstance(mockInvoker);
        }
    }

}
