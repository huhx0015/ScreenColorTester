package com.huhx0015.screencolortester.application;

import android.app.Application;
import timber.log.Timber;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public class ColorApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initializes Timber logging support.
        Timber.plant(new Timber.DebugTree());
    }
}
