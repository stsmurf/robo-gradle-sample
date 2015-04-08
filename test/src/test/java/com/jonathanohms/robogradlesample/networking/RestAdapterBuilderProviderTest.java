package com.jonathanohms.robogradlesample.networking;

import android.support.annotation.NonNull;

import com.google.inject.Provider;

import java.util.concurrent.Executor;

import retrofit.RestAdapter;

public class RestAdapterBuilderProviderTest implements Provider<RestAdapter.Builder> {

    @Override
    public RestAdapter.Builder get() {
        return new RestAdapter.Builder()
                .setExecutors(new Executor() {
                    @Override
                    public void execute(@NonNull Runnable command) {
                        command.run();
                    }
                }, null);
    }
}
