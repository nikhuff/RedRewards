package eventswithred.com.redrewards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 6/7/17.
 */

public class User {
    private String userName;
    private String userID;
    private int points;
    public List<SocialAccount> socialAccountList;

    User(String userName, String userID) {
        this.userName = userName;
        this.userID = userID;
        points = 0;
        socialAccountList = new ArrayList<>();
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

    public void setPoints(int points) {
        this.points = points;
    }
}
