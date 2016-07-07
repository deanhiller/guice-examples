package org.company.guicing.lib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SomeUtil {
    private static final Logger log = LoggerFactory.getLogger(SomeUtil.class);

    @Inject
    public SomeUtil() {
        //throw new IllegalStateException("This is to demonstrate a guice stack trace in DEVELOPMENT mode vs. PRODUCTION mode");
    }

    public RouteResponse fetchResponse(RouteRequest request) {
        log.info("some util is being called with request id="+request.getId());
        return new RouteResponse(request.getId()+20);
    }
}
