package com.jonathanohms.robogradlesample;

import android.app.Application;

import com.google.inject.Injector;

import roboguice.RoboGuice;

public class RoboGradleSampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Injector injector = RoboGuice.overrideApplicationInjector(
                this,
                RoboGuice.newDefaultRoboModule(this),
                new ApplicationModule()
        );
        injector.injectMembers(this);
    }
}
