package eventswithred.com.redrewards;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;

import static android.R.attr.start;
import static android.R.attr.tag;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private User myUser;

    public static final String PREFS_NAME = "preferences.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar top_menu_bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(top_menu_bar);
        ActionBar ab = getSupportActionBar();
        //ab.setLogo(R.drawable.logo_wide);
        ab.setDisplayShowTitleEnabled(false);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager);

        myUser = new User();
        myUser.setUserName("DanielCraig");

        // Restore preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if (settings.contains("Username")){
            myUser.setUserName(settings.getString("Username", ""));
        }
    }

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first

    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("Username", myUser.getUserName());
        editor.commit();

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    Log.d("fragment, getItem" , "returning new SocialMediaTabFragment...");
                    return new SocialMediaTabFragment();
                case 1:
                    Log.d("fragment, getItem" , "returning new PointsTabFragment...");
                    return new PointsTabFragment();
                default:
                    Log.d("fragment, getItem" , "returning new StoreTabFragment...");
                    return new StoreTabFragment();
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Feeds";
                case 1:
                    return "Points";
                case 2:
                    return "Store";
            }
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.top_menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings_button:
                Log.d("userinteraction", "user pressed the settings button");
                // User chose the "Settings" item, show the app settings UI...
                Intent intent = new Intent(this, Settings.class);
                startActivity(intent);
                return true;

            case R.id.login_button:
                Log.d("userinteraction", "user pressed the login button");
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
