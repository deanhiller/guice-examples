package org.company.guicing.lib;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketLibrary {
    private static final Logger log = LoggerFactory.getLogger(SocketLibrary.class);

    @Inject
    public SocketLibrary() {
    }

    public void bindPort(int i, RouteInvoker invoker) {
        log.info("bind server port to 8080");

    }
}
