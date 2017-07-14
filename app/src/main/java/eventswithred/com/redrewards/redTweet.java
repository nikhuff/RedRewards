package eventswithred.com.redrewards;

import java.io.Serializable;

/**
 * Created by Daniel on 7/13/2017.
 */

public class redTweet implements Serializable {
    //private twitter4j.User user;
    private String text;

    public redTweet () {
    }

    public redTweet (twitter4j.User user, String text) {
    }

    //public twitter4j.User getUser() {
//        return user;
//    }

//    public void setUser(twitter4j.User user) {
//        this.user = user;
//    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
