package com.androidtutoriels.twitterclone;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.util.Log;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

import com.twitter.sdk.android.core.*;
import com.twitter.sdk.android.core.identity.*;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.twitter.sdk.android.tweetui.TweetView;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.tweetui.UserTimeline;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String utilisateur = "fabric";
    long tweetId = 631879971628183552L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConstraintLayout mainLayout = (ConstraintLayout)findViewById(R.id.main_constraint_layout);
        final ListView listView = (ListView)findViewById(R.id.timeline_lv);

        mettreTimelineDansUtilisateur(listView, utilisateur);
        mettreTweetDansView(mainLayout, tweetId);

    }

    private void mettreTweetDansView(final ConstraintLayout mainLayout, long tweetId) {
        TweetUtils.loadTweet(tweetId, new Callback<Tweet>() {
            @Override
            public void success(Result<Tweet> result) {
                TweetView tweetView = new TweetView(MainActivity.this, result.data );
                mainLayout.addView(tweetView);
            }

            @Override
            public void failure(TwitterException exception) {
                Log.d("TwitterKit", "Load Tweet failure", exception);
            }
        });
    }

    private void mettreTimelineDansUtilisateur(ListView listView, String utilisateur) {
        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName(utilisateur)
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .build();

        listView.setAdapter(adapter);
    }


}
