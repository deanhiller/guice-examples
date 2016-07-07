package org.company.guicing;

import org.company.guicing.lib.RouteInvoker;
import org.company.guicing.lib.SocketLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockSocketLibrary extends SocketLibrary {

    private static final Logger log = LoggerFactory.getLogger(MockSocketLibrary.class);

    private RouteInvoker invoker;

    public void bindPort(int i, RouteInvoker invoker) {
        log.info("not binding a port since this is a mock object");
        this.invoker = invoker;
    }

    public RouteInvoker grabCachedInvoker() {
        return invoker;
    }
}
