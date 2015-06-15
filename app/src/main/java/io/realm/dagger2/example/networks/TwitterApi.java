package io.realm.dagger2.example.networks;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import io.realm.dagger2.example.models.Tweet;

/**
 * Created by TheFinestArtist on 6/15/15.
 */
public class TwitterApi {

    private final OkHttpClient okHttpClient;

    @Inject
    public TwitterApi(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public void post(String userane, String message) {
        Log.d(this.getClass().getSimpleName(), "Tweet Posted : " + message + " by " + userane);
    }

    public List<Tweet> load(String username, int amount) {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i < amount; i++)
            tweets.add(new Tweet(getRandomString(90), getRandomString(8)));
        return tweets;
    }

    private static final String ALLOWED_CHARACTERS = "qwertyuiopasdfghjklzxcvbnm";

    private static String getRandomString(int sizeOfRandomString) {
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(sizeOfRandomString);
        for (int i = 0; i < sizeOfRandomString; ++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }
}
