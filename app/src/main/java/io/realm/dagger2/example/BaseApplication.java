package io.realm.dagger2.example;

import android.app.Application;

import io.realm.dagger2.example.components.DaggerNetworkComponent;
import io.realm.dagger2.example.components.NetworkComponent;
import io.realm.dagger2.example.modules.NetworkModule;

/**
 * Created by TheFinestArtist on 6/15/15.
 */
public class BaseApplication extends Application {

    private NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        networkComponent = DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule())
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return networkComponent;
    }
}
