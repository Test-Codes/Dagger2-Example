package io.realm.dagger2.example.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.dagger2.example.networks.OkHttpClient;
import io.realm.dagger2.example.networks.TwitterApi;

/**
 * Created by TheFinestArtist on 6/15/15.
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    public TwitterApi provoideTwitterApi(OkHttpClient okHttpClient) {
        return new TwitterApi(okHttpClient);
    }
}
