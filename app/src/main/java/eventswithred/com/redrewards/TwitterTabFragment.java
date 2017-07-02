package eventswithred.com.redrewards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Twitter;

public class TwitterTabFragment extends Fragment {

    public List tweets = new ArrayList();
    Twitter twitter;

    public ArrayAdapter<String> tweetAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.twitter_tab_fragment, container, false);
    }
}