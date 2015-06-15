package io.realm.dagger2.example.twitters;

import javax.inject.Inject;

import io.realm.dagger2.example.networks.TwitterApi;

/**
 * Created by TheFinestArtist on 6/15/15.
 */
public class Tweeter {

    private final TwitterApi twitterApi;
    private final String username;

    @Inject
    public Tweeter(TwitterApi twitterApi, String username) {
        this.twitterApi = twitterApi;
        this.username = username;
    }

    public void tweet(String message) {
        twitterApi.post(username, message);
    }
}
