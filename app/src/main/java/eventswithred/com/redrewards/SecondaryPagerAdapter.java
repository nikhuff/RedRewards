package eventswithred.com.redrewards;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by nik on 6/11/17.
 */

public class SecondaryPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public SecondaryPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FacebookTabFragment facebookTab = new FacebookTabFragment();
                return facebookTab;
            case 1:
                TwitterTabFragment twitterTab = new TwitterTabFragment();
                return twitterTab;
            case 2:
                InstagramTabFragment instagramTab = new InstagramTabFragment();
                return instagramTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount () {
        return mNumOfTabs;
    }
}
