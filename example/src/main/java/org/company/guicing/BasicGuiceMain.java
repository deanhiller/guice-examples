package org.company.guicing;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import java.util.Arrays;
import java.util.List;

/**
 * STEP 1: Draw design on whiteboard from App.class on down via reading the constructors
 * STEP 2: explain guice initialization and BESTModuleEver
 *     - only ONE SINGLE call to getInstance
 * STEP 3: show high level test and how to do the overrides (IMAGINE you have 50 of these tests!!!!)
 * STEP 4: show low level test and how you can test any piece you want know since the design is correct (and can do it at any time) (50 tests)
 * STEP 5: show @Provides method that has too many 'new' keywords in it (SAVE for later refactoring)
 * STEP 6: show @Before in test method that constructs with too many new operators with it (50 tests)
 * STEP 7: Now, refactor Router.java such that steps 4, 5, and 6 all break!!!!
 *    -- add new biz class to constructor AND new dto to method!!
 * STEP 8: Now that those are broken, delete them(we can revert checkout anyways)
 * STEP 9: Make SomeUtil depend on App and show the guice exception and then remove(comment out new constructor)
 * STEP 10: Throw exception from SomeUtil constructor in DEVELOPMENT mode
 * STEP 11: Throw exception from SomeUtil constructor in PRODUCTION mode
 * STEP 12: Now, swap out ALL SomeUtil very easily without affecting production code!!! for performance testing purposes (thanks Brian Dupras for runnig into this use-case)
 * STEP 13: LASTLY, your server is embeddable in any other server as a library now which is a very powerful concept
 * STEP 14: OR peal off a library(create test case on the fly for this)
 * STEP 15: Avoid assisted injection as it is confusing to old and new users and is a hassle to support 
 *
 */
public class BasicGuiceMain {

    public static List<Module> getProductionModules() {
        return Arrays.<Module>asList(new BESTModuleEver());
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(getProductionModules());
        App app = injector.getInstance(App.class);

        app.start();
    }
}
