package com.jonathanohms.robogradlesample.test.support;

import android.app.Application;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import com.jonathanohms.robogradlesample.RoboGradleSampleApplication;
import com.jonathanohms.robogradlesample.networking.RestAdapterBuilderProviderTest;

import org.junit.runners.model.InitializationError;
import org.mockito.MockitoAnnotations;
import org.robolectric.AndroidManifest;
import org.robolectric.DefaultTestLifecycle;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.TestLifecycle;
import org.robolectric.annotation.Config;

import java.lang.reflect.Method;

import retrofit.RestAdapter;
import roboguice.RoboGuice;

public class RobolectricTestRunnerWithInjection extends RobolectricTestRunner {

    public RobolectricTestRunnerWithInjection(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    public static class TestApplicationModule extends AbstractModule {

        @Override
        protected void configure() {
            bind(RestAdapter.Builder.class).toProvider(RestAdapterBuilderProviderTest.class).asEagerSingleton();

            // TODO - Bind Interfaces to Fakes here for tests
        }
    }

    @Override
    protected Class<? extends TestLifecycle> getTestLifecycleClass() {
        return TestLifeCycleWithInjection.class;
    }

    public static class TestLifeCycleWithInjection extends DefaultTestLifecycle {

        private RoboGradleSampleApplication application;

        @Override
        public Application createApplication(Method method, AndroidManifest appManifest, Config config) {
            application = (RoboGradleSampleApplication) super.createApplication(method, appManifest, config);
            return application;
        }

        @Override
        public void prepareTest(Object test) {
            Module testApplicationModule = new TestApplicationModule();

            if (test instanceof AbstractModule) {
                testApplicationModule = Modules.override(testApplicationModule).with((AbstractModule) test);
            }

            RoboGuice.overrideApplicationInjector(application, RoboGuice.newDefaultRoboModule(application), testApplicationModule);
            RoboGuice.getInjector(application).injectMembers(test);
            MockitoAnnotations.initMocks(test);
        }
    }
}
