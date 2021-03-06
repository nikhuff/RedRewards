package eventswithred.com.redrewards;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 6/7/17.
 */

public class User {
    //creates the instance of the class
    private static User instance = new User();

    private String userName;
    private String userID;
    private int points;
    public List<SocialAccount> socialAccountList;

    private User() {
        this.userName = userName;
        this.userID = userID;
        points = 0;
        socialAccountList = new ArrayList<>();
    }

    public static User getUserInstance() {
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void subtractPoints(int points) {
        this.points -= points;
    }

    public boolean canSubtract(int points) {return (this.points >= points);}

    public void earnRetweetPoints(Context context) {
        addPoints(10);
        Toast.makeText(context, "You earned ten points for retweeting!", Toast.LENGTH_SHORT).show();
    }
}
