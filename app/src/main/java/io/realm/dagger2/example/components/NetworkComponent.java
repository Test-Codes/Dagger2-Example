package io.realm.dagger2.example.components;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.dagger2.example.modules.NetworkModule;
import io.realm.dagger2.example.modules.TwitterModule;
import io.realm.dagger2.example.networks.OkHttpClient;
import io.realm.dagger2.example.networks.TwitterApi;

/**
 * Created by TheFinestArtist on 6/16/15.
 */
@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {
    OkHttpClient okHttpClient();
    TwitterApi twitterApi();
    TwitterComponent plus(TwitterModule twitterModule);
}
