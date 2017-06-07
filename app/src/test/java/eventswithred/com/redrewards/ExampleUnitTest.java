package eventswithred.com.redrewards;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    User USER = new User();

    @Test
    public void User_Has_A_Name() throws Exception {
        USER.setUserName("bob");
        assertNotNull("NULL user name", USER.getUserName());
    }
    @Test
    public void User_Points_Not_negitive() throws Exception {
        assertTrue(USER.getPoints() >= 0);
    }
    @Test
    public void User_Has_An_ID() throws Exception {
        USER.setUserID("15a53e2d");
        assertNotNull("NULL user ID", USER.getUserID());
    }
}