package org.company.guicing;

import org.company.guicing.lib.RouteInvoker;
import org.company.guicing.lib.RouteResponse;

public class MockRouteInvoker extends RouteInvoker {

    private int cachedRequest;
    private RouteResponse cachedResponse;

    public MockRouteInvoker() {
        super(null);
    }

    @Override
    public RouteResponse sendRequestIntoSystem(int id) {
        this.cachedRequest = id;
        return cachedResponse;
    }

    public void setCachedResponse(RouteResponse resp) {
        this.cachedResponse = resp;
    }

    public int getCachedRequest() {
        return cachedRequest;
    }
}
