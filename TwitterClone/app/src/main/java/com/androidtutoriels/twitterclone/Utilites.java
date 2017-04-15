package com.androidtutoriels.twitterclone;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.widget.ListView;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.twitter.sdk.android.tweetui.TweetView;
import com.twitter.sdk.android.tweetui.UserTimeline;

/**
 * Created by benjaminlize on 15/04/2017.
 */

public class Utilites {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    public static final String TWITTER_KEY = "8C4EZkBBEAKFINjuqhdyQhfCV";
    public static final String TWITTER_SECRET = "rWkh18fSCZR60OFOR3bg1ogb4O1ndJpCdEOTACHqsx4DXOv3AB";

    public static void mettreTweetDansView(final Context context, final ConstraintLayout mainLayout, long tweetId) {
        TweetUtils.loadTweet(tweetId, new Callback<Tweet>() {
            @Override
            public void success(Result<Tweet> result) {
                TweetView tweetView = new TweetView(context, result.data );
                mainLayout.addView(tweetView);
            }

            @Override
            public void failure(TwitterException exception) {
                Log.d("TwitterKit", "Load Tweet failure", exception);
            }
        });
    }

    public static void mettreTimelineDansUtilisateur(Context context, ListView listView, String utilisateur) {
        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName(utilisateur)
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(context)
                .setTimeline(userTimeline)
                .build();

        listView.setAdapter(adapter);
    }
}
