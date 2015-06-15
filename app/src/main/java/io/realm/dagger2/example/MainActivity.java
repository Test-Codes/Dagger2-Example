package io.realm.dagger2.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import io.realm.dagger2.example.components.DaggerTwitterComponent;
import io.realm.dagger2.example.components.TwitterComponent;
import io.realm.dagger2.example.models.Tweet;
import io.realm.dagger2.example.modules.TwitterModule;
import io.realm.dagger2.example.twitters.Timeline;
import io.realm.dagger2.example.twitters.Tweeter;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Tweeter tweeter;
    Timeline timeline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TwitterComponent twitterComponent = DaggerTwitterComponent.builder()
                .twitterModule(new TwitterModule("TheFinestArtist"))
                .build();

        tweeter = twitterComponent.tweeter();
        timeline = twitterComponent.timeline();

        tweeter.tweet("Hello");
        findViewById(R.id.showMore).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        timeline.loadMore(20);
        for (Tweet tweet : timeline.get())
            Log.d(this.getClass().getSimpleName(), "Timeline : " + tweet.getMessage() + " by " + tweet.getUsername());
    }
}
