package eventswithred.com.redrewards;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterObjectFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by Daniel on 7/13/2017.
 */


public class TweetLoader extends AsyncTask <String, Void, Map> {
    Twitter twitter;

    public TweetLoader() {
        configureKeys();
    }

    public Map myMap = new TreeMap<Integer, redTweet>();

    @Override
    protected Map doInBackground(String... username) {
        Log.d("tweetloader", "Beginning background tweet loading...");


        try {
            List tweets = new ArrayList();
            tweets = twitter.getUserTimeline(username[0]);

            Integer tweetIndex = 0;

            for (Object item : tweets) {
                String jsonString = TwitterObjectFactory.getRawJSON(item);

                Gson g = new Gson();
                redTweet rt = g.fromJson(jsonString, redTweet.class);

                myMap.put(tweetIndex, rt);
                tweetIndex += 1;
            }

        } catch (TwitterException e) {
            e.printStackTrace();
        }

        return myMap;
    }

    protected Map onPostExecute(Long result) {
        return myMap;
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
