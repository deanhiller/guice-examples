package org.company.guicing;

import org.company.guicing.lib.MyTimer;
import org.company.guicing.lib.RouteResponse;
import org.company.guicing.lib.Router;
import org.company.guicing.lib.TemplatingEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);
    private final Router router;
    private final TemplatingEngine engine;
    private final MyTimer timer;

    @Inject
    public App(Router router, TemplatingEngine engine, MyTimer timer) {
        this.router = router;
        this.engine = engine;
        this.timer = timer;
    }

    public void start() {
        log.info("starting server");
        //potentially binds a port on the server side
        router.setup();

        timer.schedule(new DoSomething(), 5, TimeUnit.MINUTES);
        log.info("server started");
    }

    public RouteResponse sendRequestIn(int id) {
        return router.fetchResp(id);
    }

    private class DoSomething implements Runnable {
        @Override
        public void run() {
            //do something
            engine.checkStability();
        }
    }
}
