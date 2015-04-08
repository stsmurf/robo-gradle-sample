package com.jonathanohms.robogradlesample.networking;

import com.google.inject.Provider;
import com.jonathanohms.robogradlesample.RoboGradleSampleApplication;

import retrofit.RestAdapter;

public class RestAdapterBuilderProvider implements Provider<RestAdapter.Builder> {

    // The builder will allow you to set all the required pieces you need to
    // talk to the api, such as headers. Use this provider for all your
    // adapters.
    @Override
    public RestAdapter.Builder get() {

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(RoboGradleSampleApplication.getRootURL());
        return builder;
    }
}
