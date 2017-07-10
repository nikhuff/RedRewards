package eventswithred.com.redrewards;

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
}
