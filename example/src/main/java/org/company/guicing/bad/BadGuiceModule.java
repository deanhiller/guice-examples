package org.company.guicing.bad;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import org.company.guicing.lib.*;

public class BadGuiceModule implements Module {

    @Override
    public void configure(Binder binder) {
        //binder.bind(Router.class).toInstance(new Router());

    }

    @Provides
    public Router providesRouter() {
        Router r = new Router(
                new SocketLibrary(),
                new RouteInvoker(new SomeUtil())
                );

        return r;
    }

//    @Provides
//    public Router provideRouter(SocketLibrary lib, RouteInvoker invoker) {
//        return new Router(lib, invoker);
//    }
}
