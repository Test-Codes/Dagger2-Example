package io.realm.dagger2.example.twitters;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.dagger2.example.models.Tweet;
import io.realm.dagger2.example.networks.TwitterApi;

/**
 * Created by TheFinestArtist on 6/15/15.
 */
public class Timeline {

    private final List<Tweet> tweets = new ArrayList<>();
    private final TwitterApi twitterApi;
    private final String username;

    @Inject
    public Timeline(TwitterApi twitterApi, String username) {
        this.twitterApi = twitterApi;
        this.username = username;
    }

    public List<Tweet> get() {
        return tweets;
    }

    public void loadMore(int amount) {
        tweets.clear();
        tweets.addAll(twitterApi.load(username, amount));
    }
}
