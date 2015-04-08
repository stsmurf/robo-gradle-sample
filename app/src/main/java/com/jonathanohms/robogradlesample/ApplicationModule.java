package com.jonathanohms.robogradlesample;

import com.google.inject.AbstractModule;
import com.jonathanohms.robogradlesample.networking.RestAdapterBuilderProvider;

import retrofit.RestAdapter;

public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(RestAdapter.Builder.class).toProvider(RestAdapterBuilderProvider.class).asEagerSingleton();

        // TODO - Bind interfaces to real classes here
    }
}
