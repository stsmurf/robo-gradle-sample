package com.jonathanohms.robogradlesample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk=18, manifest="app/src/main/AndroidManifest.xml")
public class MainActivityTest {

    @Test
    public void shouldDoSomething() throws Exception {
        ActivityController<MainActivity> activityController = Robolectric.buildActivity(MainActivity.class);
        MainActivity mainActivity = activityController.create().resume().get();

        assertThat(mainActivity).isNotNull();
    }
}
