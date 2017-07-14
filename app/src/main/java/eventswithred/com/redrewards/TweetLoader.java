package eventswithred.com.redrewards;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.Timeline;
import com.twitter.sdk.android.tweetui.UserTimeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterObjectFactory;
import twitter4j.conf.ConfigurationBuilder;

import static java.lang.String.valueOf;

/**
 * Created by Daniel on 7/13/2017.
 */


public class TweetLoader extends AsyncTask <String, Void, List> {
    Twitter twitter;

    Gson g = new Gson();

    public TweetLoader() {
        configureKeys();
    }

    public ResponseList myTweets;
    public List tweets = new ArrayList<redTweet>();

    @Override
    protected List doInBackground(String... username) {
        Log.d("tweetloader", "Beginning background tweet loading...");

        try {
            myTweets = twitter.getUserTimeline(username[0]);

            int enumerator = 0;
            for (Object tweet: myTweets) {
                String jsonString = TwitterObjectFactory.getRawJSON(tweet);

                try {
                    Tweet tempTweet = g.fromJson(jsonString, Tweet.class);
                    redTweet tempRedTweet = new redTweet();
                    tempRedTweet.setText(tempTweet.text);
                    tweets.add(tempRedTweet);
                } catch (JsonSyntaxException syntaxE) {
                    Log.d("tweetloader", syntaxE.getMessage());
                }

                enumerator++;
            }

            //add the json back in
            Log.d("tweetloader", "Successfully loaded the tweets");
        } catch (TwitterException e) {
            Log.d("tweetloader", "Exception thrown while loading tweets: " + e.getMessage());
            e.printStackTrace();
        }
        return tweets;
    }

    protected List onPostExecute() {
        return tweets;
    }

    public void configureKeys() {
        ConfigurationBuilder cb = new ConfigurationBuilder();

        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("7R730aLClM0m4K7zrX5RDIRED")
                .setOAuthConsumerSecret("QmNnSBgyjRpoLRsid3qNov3av2zNjeksbIaWFkGNPlK930E4Xb")
                .setOAuthAccessToken("385718273-XHD6nQCuqg3iRkOsglWxGYsIcAFzhm0vyUOn387x")
                .setOAuthAccessTokenSecret("jgiIxDCOjLcCkesIJwH1cpkGnTVhH6T3SuAKWjZrSuNbI")
                .setJSONStoreEnabled(true);

        TwitterFactory tf = new TwitterFactory(cb.build());
        this.twitter = tf.getInstance();
    }
}
