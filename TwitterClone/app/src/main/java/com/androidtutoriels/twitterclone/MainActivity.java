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

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "8C4EZkBBEAKFINjuqhdyQhfCV";
    private static final String TWITTER_SECRET = "rWkh18fSCZR60OFOR3bg1ogb4O1ndJpCdEOTACHqsx4DXOv3AB";

    private TwitterLoginButton loginButton;

    String utilisateur = "fabric";
    long tweetId = 631879971628183552L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Twitter authentication configuration
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_main);

        final ConstraintLayout mainLayout = (ConstraintLayout)findViewById(R.id.main_constraint_layout);
        final ListView listView = (ListView)findViewById(R.id.timeline_lv);

        mettreTimelineDansUtilisateur(listView, utilisateur);
        mettreTweetDansView(mainLayout, tweetId);


        //Login bouton
        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // The TwitterSession is also available through:
                // Twitter.getInstance().core.getSessionManager().getActiveSession()
                TwitterSession session = result.data;
                // TODO: Remove toast and use the TwitterSession's userID
                // with your app's user model
                String msg = "@" + session.getUserName() + " logged in! (#" + session.getUserId() + ")";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
            @Override
            public void failure(TwitterException exception) {
                Log.d("TwitterKit", "Login with Twitter failure", exception);
            }
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Make sure that the loginButton hears the result from any
        // Activity that it triggered.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

}
