package eventswithred.com.redrewards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import java.util.ArrayList;
import java.util.List;

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

        TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();

        UserTimeline userTimeline = new UserTimeline.Builder().screenName("eventswithred").build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getActivity())
                .setTimeline(userTimeline)
                .build();

        ListView lv = (ListView) getActivity().findViewById(R.id.tweet_list_view);
        lv.setAdapter(adapter);


        /*loginButton = (TwitterLoginButton) getActivity().findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
            }
        });*/


    }

}