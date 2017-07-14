package eventswithred.com.redrewards;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by Daniel on 7/13/2017.
 */

public class redTweet implements Serializable {
    //private twitter4j.User user;
    private String user;
    private String text;

    public redTweet () {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        Log.d("redTweet", "The text of this redTweet object has been set to " + text);
        this.text = text;
    }
}
