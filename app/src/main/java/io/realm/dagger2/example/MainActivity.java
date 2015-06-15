package io.realm.dagger2.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

import dagger.ObjectGraph;
import io.realm.dagger2.example.models.Tweet;
import io.realm.dagger2.example.modules.TwitterModule;
import io.realm.dagger2.example.twitters.Timeline;
import io.realm.dagger2.example.twitters.Tweeter;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Inject
    Tweeter tweeter;
    @Inject
    Timeline timeline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BaseApplication app = (BaseApplication) getApplication();
        ObjectGraph og = app.getObjectGraph();
        og.plus(new TwitterModule("TheFinestArtist")).inject(this);

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
