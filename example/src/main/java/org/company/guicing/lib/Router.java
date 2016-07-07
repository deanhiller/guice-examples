package org.company.guicing.lib;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Router {

    private final SocketLibrary library;
    private final RouteInvoker invoker;

    @Inject
    public Router(SocketLibrary library, RouteInvoker invoker) {
        this.library = library;
        this.invoker = invoker;
    }

    public void setup() {
        library.bindPort(8080, invoker);
    }

    public RouteResponse fetchResp(int id) {
        return invoker.sendRequestIntoSystem(id);
    }
}
