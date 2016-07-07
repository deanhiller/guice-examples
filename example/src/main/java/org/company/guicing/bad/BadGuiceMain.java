package org.company.guicing.bad;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.company.guicing.App;

import java.util.Arrays;
import java.util.List;

public class BadGuiceMain {

    public static List<Module> getProductionModules() {
        return Arrays.<Module>asList(new BadGuiceModule());
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(getProductionModules());
        App app = injector.getInstance(App.class);

        app.start();

        app.sendRequestIn(99);
    }

}
