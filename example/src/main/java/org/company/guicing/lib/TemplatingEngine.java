package org.company.guicing.lib;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TemplatingEngine {

    private final SomeUtil util;

    @Inject
    public TemplatingEngine(SomeUtil util) {
        this.util = util;
    }
    
    public void checkStability() {

    }
}
