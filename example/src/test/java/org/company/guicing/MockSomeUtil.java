package org.company.guicing;

import org.company.guicing.lib.RouteRequest;
import org.company.guicing.lib.RouteResponse;
import org.company.guicing.lib.SomeUtil;

public class MockSomeUtil extends SomeUtil {

    private RouteRequest cachedRequest;
    private RouteResponse cachedResponse;

    public RouteResponse fetchResponse(RouteRequest routeRequest) {
        this.cachedRequest = routeRequest;
        return cachedResponse;
    }

    public void setCachedResponse(RouteResponse resp) {
        this.cachedResponse = resp;
    }

    public RouteRequest getCachedRequest() {
        return cachedRequest;
    }
}
