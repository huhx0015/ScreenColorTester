package com.huhx0015.screencolortester.application;

import android.app.Application;
import com.squareup.leakcanary.LeakCanary;
import timber.log.Timber;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public class ColorApplication extends Application {

    /** APPLICATION LIFECYCLE METHODS __________________________________________________________ **/

    @Override
    public void onCreate() {
        super.onCreate();

        // LEAK CANARY:
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        // TIMBER: Initializes Timber logging support.
        Timber.plant(new Timber.DebugTree());
    }
}
