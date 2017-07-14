package eventswithred.com.redrewards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.BaseTweetView;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TwitterListTimeline;
import com.twitter.sdk.android.tweetui.UserTimeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class TwitterTabFragment extends Fragment {

    public List tweets = new ArrayList();

    public ArrayAdapter<String> tweetAdapter;

    private TwitterLoginButton loginButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Twitter.initialize(super.getContext());

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.twitter_tab_fragment, container, false);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d("twitterTabFragment", "Loading the tweets.");

        TweetLoader tl = new TweetLoader();
        try {
            Map <Integer, redTweet> myMap = tl.execute("eventswithred").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //generate list
        ArrayList<redTweet> list = new ArrayList<redTweet>();
        //list.add(userTimeline.get(0));
        //list.add("item2");

        //instantiate custom adapter
        customArrayAdapter adapter = new customArrayAdapter(list, getActivity());

        //handle listview and assign adapter
        //ListView lView = (ListView)getActivity().findViewById(R.id.tweet_list_view);
        //lView.setAdapter(adapter);





// this code is a little closed - I'm going to rewrite it so that I can make a custom layout for each tweet

        //Log.d(this, "The timeline has " +

//        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getActivity())
//                .setTimeline(userTimeline)
//                .build();

//        ListView lv = (ListView) getActivity().findViewById(R.id.tweet_list_view);
//        lv.setAdapter(adapter);

        loginButton = (TwitterLoginButton) getActivity().findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls

            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
            }

        });

        /*Button pointButton = (Button) getActivity().findViewById(R.id.earn_points);
        pointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = User.getUserInstance();
                user.addPoints(10);
                Toast.makeText(getActivity(), "Simulated sharing post!", Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}