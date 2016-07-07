package org.company.guicing;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import org.company.guicing.lib.SomeUtil;

import javax.inject.Singleton;

public class BESTModuleEver implements Module {
    @Override
    public void configure(Binder binder) {

    }

//    @Provides
//    @Singleton
//    public SomeUtil provideIt() {
//        return new SomeUtil();
//    }
}
