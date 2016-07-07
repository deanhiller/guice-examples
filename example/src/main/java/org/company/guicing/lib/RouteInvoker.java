package org.company.guicing.lib;

import com.google.inject.Inject;

public class RouteInvoker {

    private final SomeUtil util;

    @Inject
    public RouteInvoker(SomeUtil util) {
        this.util = util;
    }

    public RouteResponse sendRequestIntoSystem(int id) {
        return util.fetchResponse(new RouteRequest(id));
    }
}
