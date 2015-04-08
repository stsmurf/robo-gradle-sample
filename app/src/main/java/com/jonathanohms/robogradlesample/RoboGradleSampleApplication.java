package com.jonathanohms.robogradlesample;

import android.app.Application;

import com.google.inject.Injector;

import roboguice.RoboGuice;

public class RoboGradleSampleApplication extends Application {

    public static String getRootURL() {
//        return "http://192.168.56.1:3000/"; // Genymotion localhost
        return "http://api.example.com";
    }

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
