package eventswithred.com.redrewards;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class FacebookTabFragment extends Fragment {
    String TAG = "Facebook";
    AccessToken token = AccessToken.getCurrentAccessToken();
    LoginButton loginButton;
    CallbackManager callbackManager;

    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;

        if (isLoggedIn()) {
            view = inflater.inflate(R.layout.facebook_tab_fragment, container, false);
        } else {
            view = inflater.inflate(R.layout.facebook_login, container, false);
        }

        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setFragment(this);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Log.d(TAG, "Login successful");
            }

            @Override
            public void onCancel() {
                // App code
                Log.d(TAG, "canceled login");
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Log.d(TAG, "Login unsuccessful. Exception: " + exception.toString());
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Fragment created");

        new GraphRequest(
                token,
                "/922252361131170/feed",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        /* handle the result */
                        Log.d(TAG, response.toString());
                    }
                }
        ).executeAsync();
    }
}